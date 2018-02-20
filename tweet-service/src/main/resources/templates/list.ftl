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
		                <th>Followers</th>
						<th>email</th>
		                <th>Hash Tag</th>
						<th>Auteur</th>
		                <th>Message</th>
		            </tr>
		            </thead>
		            <tbody>
		            <tr ng-repeat="u in ctrl.getAllTweets()">
		                <td>{{u.followersCount}}</td>
		                <td>{{u.email}}</td>
						<td>{{u.tag}}</td>
		                <td>{{u.autheur}}</td>
						<td>{{u.libelle}}</td>
					</tr>
		            </tbody>
		        </table>		
			</div>
		</div>
    </div>
</div>