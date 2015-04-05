<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="orgApp">
<head>
<title>Organizations</title>

<%@include file="includes/commonresources.jsp"%>

<script src="/resources/jslib/angular.js"></script>

<script>
	window.dataObject = {
			organization : {
				name : 'BurgarKedjan',
				description : 'Fokuserad på att skapa smaskiga burgare',
				company : [
					{
						companyId : 'bk01',
						name : 'Kalles färska burgare',
						location : 'Gamla stan'},
					{
						companyId : 'bk02',
						name : 'Bennys Burger',
						location : 'Vasastan'
					}
				]
		}
	};

	angular.module('orgApp',[])
		.controller('OrganizationListController', function($scope){
			$scope.orgz = [window.dataObject.organization]; // List of organizations
			/* Organization strucuter
			{ name : 'BurgarKedjan',
			  company : [
				  {
					  companyId : 'bk01',
					  name : 'Kalles färska burgare',
					  location : 'Gamla stan'},
				  },{..}
			  ]
			}
			*/
			$scope.$on('newOrg',function(event, newOrg){
				// New Organization has been created
				$scope.orgz.push(newOrg)
				console.log('Adding new organization: ', newOrg);
			});
		})
		.controller('NewOrganizationController', function($scope){
			var newOrg = this;
			$scope.show = false;
			$scope.name = '';
			$scope.description = '';
			newOrg.create = function(){
				console.log('Saving new organization ', {name:$scope.name, description:$scope.description});
				var org = {
						name : $scope.name,
						description : $scope.description,
						company : []
				};
				$scope.$parent.$broadcast('newOrg',org);
				$scope.show = false;
				// TODO: Call server
			};
		});
	</script>
</head>
<body>

	<%@include file="includes/headermenu.jsp"%>

	<!-- Main Content -->

	<div class="container" style="padding-top: 150px">

		<div ng-controller="NewOrganizationController as newOrg">
			<div ng-hide="show">
				<button ng-click="show = true" class="btn btn-primary">Create
					New</button>
			</div>
			<div ng-show="show">
				<form ng-submit="newOrg.create()">
					<h1>Create new organization</h1>
					Name: <input type="text" placeholder="Name of the organization"
						ng-model="name" /> <br> Description: <input type="text"
						ng-model="description" /> <input type="submit"
						class="btn btn-primary" value="Create" />
					<button ng-click="show = false" class="btn btn-primary">Cancel</button>
				</form>
			</div>
		</div>

		<div ng-controller="OrganizationListController as orgList">
			<div ng-repeat="org in orgz">
			
				<h1>Organization {{org.name}}</h1>
				<i>{{org.description}}</i>
				<div>
					<div ng-repeat="company in org.company">
						<h4 data-id="{{company.companyId}}">{{company.name}}</h4>
						<span>Located at {{company.location}}</span>
					</div>
				</div>
			</div>
		</div>


	</div>


	<%@include file="includes/commonfoot.jsp"%>
	<script>
		var dataObj = ${org};	
	</script>
</body>
</html>