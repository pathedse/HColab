<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html ng-app="orgApp">
<head>
<title>Organizations</title>

<%@include file="includes/commonresources.jsp"%>




<script>
	window.dataObject = {
			organization :  ${org}
		
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
	$(function(){
		$( "#date" ).datepicker();
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
		<input type="text" id="date" />
		<div ng-controller="OrganizationListController as org">
			<div ng-repeat="org in orgz">			
				<h1>Organization {{org.name}}</h1>
				<div class="orgToolBar">
				<span class="editOrg" orgId="{{org.id}}">Edit</span>
				</div>
				<i>{{org.description}}</i>
				<div>
					<div ng-repeat="company in org.businesUnits">
						<h4 data-id="{{company.id}}">{{company.name}}</h4>
						<span>Located at {{company.description}}</span>
					</div>
				</div>
			</div>
		</div>


	</div>
	
	
<div id="dialog" title="Create new user">
  <p class="validateTips">All form fields are required.</p>
 
  <form>
    <fieldset>
      <label for="name">Name</label>
      <input type="text" name="name" id="name" value="Jane Smith" class="text ui-widget-content ui-corner-all">
      <label for="email">Email</label>
      <input type="text" name="email" id="email" value="jane@smith.com" class="text ui-widget-content ui-corner-all">
      <label for="password">Password</label>
      <input type="password" name="password" id="password" value="xxxxxxx" class="text ui-widget-content ui-corner-all">
 
      <!-- Allow form submission with keyboard without duplicating the dialog button -->
      <input type="submit" tabindex="-1" style="position:absolute; top:-1000px">
    </fieldset>
  </form>
</div>

	<%@include file="includes/commonfoot.jsp"%>
	<script>
		var dataObj = ${org};	
	</script>
	<script type="text/javascript">
	 $(function() {
		 $( "#dialog" ).dialog({
			  dialogClass: "no-close",
			  buttons: [
			    {
			      text: "OK",
			      click: function() {
			        $( this ).dialog( "close" );
			      }
			    }
			  ]
			});
		  });
	</script>
</body>
</html>