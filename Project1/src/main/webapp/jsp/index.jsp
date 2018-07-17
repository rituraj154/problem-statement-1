<html>

<head>
<script src="https://cdnjs.cloudflare.com/ajax/libs/angular.js/1.7.2/angular.min.js" type ="text/javascript"></script>

<script
  src="https://code.jquery.com/jquery-3.3.1.min.js"
  integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
  crossorigin="anonymous"></script>

  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.2/css/bootstrap.min.css">
  <style>
table{
border-collapse:collapse;
}
tr{
border:1px solid black;
}
tr:nth-child{
background:blue;
}

td,th{
padding-left:8px;
padding-right:8px;
text-align:center;

}
th{
}
.outer *{
vertical-align:top;
}
.final{
text-align:right;
font-weight:bold;
}

textarea{
    height: 153px;
    width: 708px;}
</style>



</head>

<body ng-app = "billing_app">
<div class = "outer" ng-controller = "billing_controller">
<label>JSON Input: </label><textarea type="text" ng-model="input"></textarea>
<input type = "button" ng-click="generateBill()" value="Click here to generate bill">

<h1 ng-if="present">Invoice</h1>
<label>{{error}}</label>
<table id="theTable" ng-if="present">
<tr>
<th>SNO</th><th>Product Name</th><th>Product Quantity</th><th>MRP</th><th>Price</th>
</tr>
<tr ng-repeat="x in bill">
<td>{{$index+1}}</td>
<td>{{x.productName}}</td>
<td>{{x.productQuantity}}</td>
<td>{{x.productMRP}}</td>
<td>{{x.finalMRP}}</td>
</tr>
<tr>

<td class='final' colspan = "5">Total: {{other.finalMrp}}<br>
Tax: {{other.finalTax}}<br>
Amount: {{other.totalAmount}}
</td>
</tr>
</table>

</div>

</body>
<script>

var app = angular.module("billing_app",[]);
app.controller("billing_controller",function($scope,$http){
$scope.input = '[{"productCategory":"A","productMRP":23.32,"productName":"PRODUCT1","productQuantity":4},{"productCategory":"B","productMRP":23.32,"productName":"PRODUCT2","productQuantity":2},{"productCategory":"C","productMRP":23.32,"productName":"PRODUCT3","productQuantity":3},{"productCategory":"A","productMRP":23.32,"productName":"PRODUCT4","productQuantity":5}]';
$scope.present = false;
$scope.generateBill = function(){
var input = $scope.input ;
if(input=="" || input==null){
input = '[{"productCategory":"A","productMRP":23.32,"productName":"PRODUCT1","productQuantity":4},{"productCategory":"B","productMRP":23.32,"productName":"PRODUCT2","productQuantity":2},{"productCategory":"C","productMRP":23.32,"productName":"PRODUCT3","productQuantity":3},{"productCategory":"A","productMRP":23.32,"productName":"PRODUCT4","productQuantity":5}]';
}


$http({
url:"http://localhost:8080/processBill",
method: "POST",
data:input,
headers:{'Content-Type':'application/json','Authorization':'Basic YWRtaW46YWRtaW4='}
}).then(function(data){
$scope.other = data.data;
$scope.bill = data.data.finalProducts;
console.log(data);
$scope.present = true;
},function(error){

$scope.error = error.data.error;

});



}

});

</script>

</html>