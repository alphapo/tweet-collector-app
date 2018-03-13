<div>
    <div ng-if="ctrl.logged != 'success'" class="panel-default">
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Name</label>
                            <div class="col-md-7">
                                <input type="text" ng-model="ctrl.user.login" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="age">Password</label>
                            <div class="col-md-7">
                                <input type="password" ng-model="ctrl.user.password" id="password" class="form-control input-sm" placeholder="Enter your password." required ng-minlength="8"/>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions center">
                            <input type="submit" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div ng-if="ctrl.logged == 'success'" class="panel-default">
            <div class="row">
                <button type="submit" ng-click="ctrl.logOut()" class="btn btn-primary btn-sm">Déconnexion</button>
            </div>
    </div>

    <div ng-if="ctrl.logged == 'success'" class="panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading">
            <span class="lead">List des Tweets </span>
        </div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>Auteur</th>
                        <th>Followers</th>
                        <th>email</th>
                        <th>Hash Tag</th>
                        <th>Message</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllTweets()">
                        <td>{{u.auteur}}</td>
                        <td>{{u.follewersCount}}</td>
                        <td ng-if="u.email != 'null'">{{u.email}}</td>
                        <td ng-if="u.email == 'null'"></td>
                        <td>{{u.tag}}</td>
                        <td>{{u.libelle}}</td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>