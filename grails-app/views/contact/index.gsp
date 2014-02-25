<!DOCTYPE html>
<html ng-app="contact">
<head>
    <r:require module="contactApp"/>
    <r:layoutResources/>
</head>
<body ng-controller="contactCtrl">
    <div class="contact-container">
        <div>
            <button pop id="api" class="btn btn-sm btn-success" ng-click="facebookContacts()">Get Facebook Contacts</button>
        </div>
        <br>
        <div ng-show="showLogin" style="width: 70%">
            <h4 class="alert alert-danger" ng-hide="result.token || result[0]">Unauthenticated to access resource. Please login to generate token</h4>
            <div class="input-group" style="width: 250px; text-align: center">
                <span class="input-group-addon">username:</span>
                <input class="form-control" autofocus type="text" ng-model="user.username"
                       placeholder="hint: user">
            </div>
            <br>
            <div class="input-group" style="width: 250px; text-align: center">
                <span class="input-group-addon">password:</span>
                <input class="form-control" type="password" ng-model="user.password" placeholder="hint: pass">
            </div>
            <br>
            <div>
                <button class="btn btn-primary" ng-click=authenticate()>Authenticate</button>
            </div>
        </div>
        <br>
        <div ng-show="showLogin">
            <pre ng-show="showLogin"><code>{{ result | json }}</code></pre>
        </div>
    </div>

    <r:layoutResources/>
</body>
</html>