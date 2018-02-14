<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List des Tweets </span></div>
		<div class="panel-body">
			<div class="table-responsive">
		        <table class="table table-hover">
		            <thead>
		            <tr>
		                <th>Auteur</th>
		                <th>Détail du tweet</th>
		                <th width="100"></th>
		                <th width="100"></th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllTweets()">
		                <td>{{u.auteur}}</td>
		                <td>{{u.libelle}}</td>
					</tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>