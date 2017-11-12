var app=angular.module("app",[]);
app.controller("controller", function($scope, $http, $window, sharedProperties){
	  $scope.generate = function(){
	    $http.get('http://localhost:8010/ConcentMgt/consentapi/sendmail').
	    then(function mySucces(response) {
	      $scope.error = "";
	      sharedProperties.setData(response.data);
	      $window.location.href = '/ErrorLink.jsp';
	    }, function myError() {
	      $scope.error = "Wrong Username";
	    });
	  }
	});

	app.controller("resultController", function($scope, $window,sharedProperties){
	  $scope.names = sharedProperties.getData();
	  $scope.home = function() {
	    $window.location.href = '/loginForm.jsp';
	  }
	  });
	
	app.service('sharedProperties', function() {
	    return {
	        getData: function() {
	            return angular.fromJson(sessionStorage.sharedProperties);
	        },
	        setData: function(value) {
	           sessionStorage.sharedProperties = angular.toJson(value);
	        },
	    }
	});





/*app.controller("myController",function($scope,$http){
	
	$scope.getBookList=function(){
		
		$http.get('http://localhost:8080/DevDarshan/getBooksList').success(function(data){
			
			$scope.books=data;
			
		});
	};
	
			$scope.addToCart=function(isbn){
				
				$http.put('http://localhost:8080/DevDarshan/cart/add/'+isbn).success(function(){
						
							alert('Added Successfully To The Cart');
			
			});
				
			}
			
			
			
			$scope.refreshCart=function(){
				alert('Enter In Refresh'+$scope.cartId);
			$http.get('http://localhost:8080/DevDarshan/cart/getCart/'+$scope.cartId).success(function(data){
					$scope.cart=data;
			});
				
				
			}
			
			$scope.getCart=function(cartId){
				
			alert('CART ID FIRST='+cartId);
				$scope.cartId=cartId;
				$scope.refreshCart(cartId);
				
			}
			
			
			$scope.removeFromCart=function(cartitem){
				
				$http.put('http://localhost:8080/DevDarshan/cart/removecartitem/'+cartitem).success(function(){
					
						$scope.refreshCart();
				});
				
			};
			
			$scope.clearCart=function(){
				
				$http.put('http://localhost:8080/DevDarshan/cart/removeAllItems/'+$scope.cartId).success(function(){
					
					$scope.refreshCart();
				});
			};
			
			$scope.calculateGrandTotal=function(){
				
				var grandTotal=0.0;
				for(var i=0; i< $scope.cart.cartItems.length;i++){
					
					grandTotal=grandTotal + $scope.cart.cartItems[i].totalPrice;
					alert('GradTotal='+grandTotal);
					
				}
				return grandTotal; 
			}
			
	
});*/