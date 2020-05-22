<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Analyze your code by statements or variables or methods</title>
        
       <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
       
       <style>

.hoverable{
  display:inline-block;
  backface-visibility: hidden;
  vertical-align: middle;
  position:relative;
  box-shadow: 0 0 1px rgba(0,0,0,0);
  tranform: translateZ(0);
  transition-duration: .3s;
  transition-property:transform;
  
}

.hoverable:before{
  position:absolute;
  pointer-events: none;
  z-index:-1;
  content: '';
  top: 100%;
  left: 5%;
  height:10px;
  width:90%;
  opacity:0;
  background: blue;
  background: radial-gradient(ellipse at center, rgba(255, 255, 255, 0.35) 0%, rgba(255, 255, 255, 0) 80%);
  /* W3C */
  transition-duration: 0.3s;
  transition-property: transform, opacity;
  
}

.hoverable:hover, .hoverable:active, .hoverable:focus{
  transform: translateY(-5px);
}
.hoverable:hover:before, .hoverable:active:before, .hoverable:focus:before{
  opacity: 1;
  transform: translateY(-5px);
}



@keyframes bounce-animation {
  16.65% {
    -webkit-transform: translateY(8px);
    transform: translateY(8px);
  }

  33.3% {
    -webkit-transform: translateY(-6px);
    transform: translateY(-6px);
  }

  49.95% {
    -webkit-transform: translateY(4px);
    transform: translateY(4px);
  }

  66.6% {
    -webkit-transform: translateY(-2px);
    transform: translateY(-2px);
  }

  83.25% {
    -webkit-transform: translateY(1px);
    transform: translateY(1px);
  }

  100% {
    -webkit-transform: translateY(0);
    transform: translateY(0);
  }
}

.bounce {
  animation-name: bounce-animation;
  animation-duration: 2s;
}

.hideDiv{
	display: none;
}

.displayDiv{
	display: block;
}

/*everything below here is just setting up the page, so dont worry about it */


@media (min-width: 768px) {

body {
  background-color: blue;
  font-weight:600;
  text-align:center !important;
  color: black;
  
}


.page-title {
  opacity: .75 !important;
}

table1, td, th {
  border: 1px solid black;
}

table1 {
  border-collapse: collapse;
  width: 100%;
}

th {
  text-align: left;
}

</style>
<script>
$(function(){
  var str = '#len'; //increment by 1 up to 1-nelemnts
  $(document).ready(function(){
    var i, stop;
    i = 1;
    stop = 4; //num elements
    setInterval(function(){
      if (i > stop){
        return;
      }
      $('#len'+(i++)).toggleClass('bounce');
    }, 500)
  });
});
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
       
    </head>
  
    <body style="background-color:white;">

<div class="container-fluid">

<div id="what-the-hell-is-this">
    <div class="page-title">
      <h2>Code Complexity Measuring Tool</h2>
     
    </div>
  </div>
</div>

  <!--nav>
   
 
  </nav-->
  
  <form method="POST"  target="_blank" action="testServlet" >
   
        <br>
        
          <hr>
          <div align=center  class="form-group mt-3" >
           <p>Upload Your Code:</p>
            <textarea rows="5" cols="80" name="code" required></textarea>
          </div>
          <hr>
          
          	<select id="selectOption" name="selectFactor" onchange="setDiv()" required>
          		<option value="">~Select~</option>
				<option value="size">Size Factor</option>
				<option value="variable">Variable Factor</option>
				<option value="method">Method Factor</option>
				<option value="controlStructure">Control Structure Factor</option>
				<option value="inheritance">Inheritance Factor</option>
				<option value="coupling">Coupling Factor</option>
				<option value="all">All The Factor</option>
			</select>
			
          <hr>
          
         			<div class="hideDiv" style="margin: auto;width:600px" id="sizeFactor" style="margin: auto;width:600px">
		  			<br>
		  				<h5 align="center">Weight Related To The Size Factor</h5>
		  				<center>
		  				<table class="table1">
  							<thead class="thead-light">
			  					<tr>
			  						<th>Program Component</th>
			  						<th>Weight</th>
			  					</tr>
			  				</thead>
			  				<tbody>
			  					<tr>
			  						<td>Keyword</td>
			  						<td>
							  			<select class="form-control" name="sizeKeyword">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
			  						</td>
			  					</tr>
			  					<tr>
			  						<td>Identifier</td>
			  						<td>
							  			<select class="form-control" name="sizeIdentifier">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>Operator</td>
			  						<td>
							  			<select class="form-control" name="sizeOperator">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>Numerical Value</td>
			  						<td>
							  			<select class="form-control" name="sizeNumerical">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>String Iiteral</td>
			  						<td>
							  			<select class="form-control" name="sizeString">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  				</tbody>
		  				</table>
		  				</center>
		  			</div>
		  			<div class="hideDiv" style="margin: auto;width:600px" id="variableFactor">
		  			<br>
		  				<h5 align="center">Weight Related To The Variable Factor</h5>
		  				<center>
		  				<table class="table1">
  							<thead class="thead-light">
			  					<tr>
			  						<th>Program Component</th>
			  						<th>Weight</th>
			  					</tr>
			  				</thead>
			  				<tbody>
			  					<tr>
			  						<td>Global Variable</td>
			  						<td>
							  			<select class="form-control" name="variableGlobal">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
			  						</td>
			  					</tr>
			  					<tr>
			  						<td>Local Variable</td>
			  						<td>
							  			<select class="form-control" name="variableLocal">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>Primitive Data Type Variable</td>
			  						<td>
							  			<select class="form-control" name="variablePrimitive">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>Composite Data Type Variable</td>
			  						<td>
							  			<select class="form-control"  name="variableComposite">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  				</tbody>
		  				</table>
		  				</center>
		  			</div>
		  			<div class="hideDiv" style="margin: auto;width:600px" id="methodFactor">
		  			<br>
		  				<h5 align="center">Weight Related To The Method Factor</h5>
		  				<center>
		  				<table class="table1">
  							<thead class="thead-light">
			  					<tr>
			  						<th>Program Component</th>
			  						<th>Weight</th>
			  					</tr>
			  				</thead>
			  				<tbody>
			  					<tr>
			  						<td>Method with a primitive return type</td>
			  						<td>
							  			<select class="form-control" name="methodPrimitive">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
			  						</td>
			  					</tr>
			  					<tr>
			  						<td>Method with a composite return type</td>
			  						<td>
							  			<select class="form-control" name="methodComposite">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>Primitive data type parameter</td>
			  						<td>
							  			<select class="form-control" name="methodPrimitiveData">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>Composite data type parameter</td>
			  						<td>
							  			<select class="form-control" name="methodCompositeData">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  				</tbody>
		  				</table>
		  				</center>
		  			</div>
		  			<div class="hideDiv" style="margin: auto;width:600px" id="structureFactor">
		  			<br>
		  				<h5 align="center">Weight Related To The Control Structure Factor</h5>
		  				<center>
		  				<table class="table1">
  							<thead class="thead-light">
			  					<tr>
			  						<th>Control Structure Type</th>
			  						<th>Weight</th>
			  					</tr>
			  				</thead>
			  				<tbody>
			  					<tr>
			  						<td>A conditional control structure such as an 'if' or 'else-if' condition</td>
			  						<td>
							  			<select class="form-control" name="condition">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
			  						</td>
			  					</tr>
			  					<tr>
			  						<td>An iterative control structure such as an 'for' , 'while' , or 'do-while' loop</td>
			  						<td>
							  			<select class="form-control" name="loop">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>The 'switch' statement in a 'switch-case' control structure</td>
			  						<td>
							  			<select class="form-control" name="switchCase">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>Each 'case' statement in a 'switch-case' control structure</td>
			  						<td>
							  			<select class="form-control" name="caseOnly">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  				</tbody>
		  				</table>
		  				</center>
		  			</div>
		  			<div class="hideDiv" style="margin: auto;width:600px" id="inheritanceFactor">
		  			<br>
		  				<h5 align="center">Weight Related To The Inheritance Factor</h5>
		  				<center>
		  				<table class="table1">
  							<thead class="thead-light">
			  					<tr>
			  						<th>Inherited Pattern</th>
			  						<th>Weight</th>
			  					</tr>
			  				</thead>
			  				<tbody>
			  					<tr>
			  						<td>A class with no Inheritance(direct or indirect)</td>
			  						<td>
							  			<select class="form-control" name="Inheritance">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
			  						</td>
			  					</tr>
			  					<tr>
			  						<td>A class inheriting(direct or indirect) from one user-defined class</td>
			  						<td>
							  			<select class="form-control" name="Inheritance1">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A class inheriting(direct or indirect) from two user-defined classes</td>
			  						<td>
							  			<select class="form-control" name="Inheritance2">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A class inheriting(direct or indirect) from three user-defined classes</td>
			  						<td>
							  			<select class="form-control" name="Inheritance3">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A class inheriting(direct or indirect) from more than three user-defined classes</td>
			  						<td>
							  			<select class="form-control" name="Inheritance4">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  				</tbody>
		  				</table>
		  				</center>
		  			</div>
		  			<div class="hideDiv" style="margin: auto;width:600px" id="couplingFactor">
		  			<br>
		  				<h5 align="center">Weight Related To The Coupling Factor</h5>
		  				<center>
		  				<table class="table1">
  							<thead class="thead-light">
			  					<tr>
			  						<th>Coupling Type</th>
			  						<th>Weight</th>
			  					</tr>
			  				</thead>
			  				<tbody>
			  					<tr>
			  						<td>A recursive call</td>
			  						<td>
							  			<select class="form-control" name="recursive">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
			  						</td>
			  					</tr>
			  					<tr>
			  						<td>A regular method calling another regular method in the same file</td>
			  						<td>
							  			<select class="form-control" name="regularRegular">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A regular method calling another regular method in a different file</td>
			  						<td>
							  			<select class="form-control">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A regular method calling a recursive method in the same file</td>
			  						<td>
							  			<select class="form-control" name="regularRecursive">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A regular method calling a recursive method in a different file</td>
			  						<td>
							  			<select class="form-control">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A recursive method calling another recursive method in the same file</td>
			  						<td>
							  			<select class="form-control" name="recursiveRecursive">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A recursive method calling another recursive method in a different file</td>
			  						<td>
							  			<select class="form-control">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A recursive method calling a regular method in the same file</td>
			  						<td>
							  			<select class="form-control" name="recursiveRegular">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A recursive method calling a regular method in a different file</td>
			  						<td>
							  			<select class="form-control">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A regular method referencing a global variable in the same file</td>
			  						<td>
							  			<select class="form-control" name="regularGlobal">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A regular method referencing a global variable in a different file</td>
			  						<td>
							  			<select class="form-control">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A recursive method referencing a global variable in the same file</td>
			  						<td>
							  			<select class="form-control" name="recursiveGlobal">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  					<tr>
			  						<td>A recursive method referencing a global variable in a different file</td>
			  						<td>
							  			<select class="form-control">
							  				<option value="0">0</option>
							  				<option value="1">1</option>
							  				<option value="2">2</option>
							  				<option value="3">3</option>
							  				<option value="4">4</option>
							  			</select>
							  		</td>
			  					</tr>
			  				</tbody>
		  				</table>
		  				</center>
		  			</div>
          
          
          <button type="submit" class="btn btn-primary" value="Run" >Run</button>
       
        </form>
  
  

       
    </body>
</html>
<script>

	function setDiv(){
		var div = document.getElementById('selectOption').value;
		
		if(div=="size"){
			hideAll();
			document.getElementById('sizeFactor').classList.add("displayDiv");
		}else if(div=="variable"){
			hideAll();
			document.getElementById('variableFactor').classList.add("displayDiv");
		}else if(div=="method"){
			hideAll();
			document.getElementById('methodFactor').classList.add("displayDiv");
		}else if(div=="controlStructure"){
			hideAll();
			document.getElementById('structureFactor').classList.add("displayDiv");
		}else if(div=="inheritance"){
			hideAll();
			document.getElementById('inheritanceFactor').classList.add("displayDiv");
		}else if(div=="coupling"){
			hideAll();
			document.getElementById('couplingFactor').classList.add("displayDiv");
		}else if(div=="all"){
			hideAll();
		}else{
			hideAll();
		}
	}
	
	function hideAll(){
		
		document.getElementById('sizeFactor').classList.remove("displayDiv");
		document.getElementById('variableFactor').classList.remove("displayDiv");
		document.getElementById('methodFactor').classList.remove("displayDiv");
		document.getElementById('structureFactor').classList.remove("displayDiv");
		document.getElementById('inheritanceFactor').classList.remove("displayDiv");
		document.getElementById('couplingFactor').classList.remove("displayDiv");
		
		document.getElementById('sizeFactor').classList.add("hideDiv");
		document.getElementById('variableFactor').classList.add("hideDiv");
		document.getElementById('methodFactor').classList.add("hideDiv");
		document.getElementById('structureFactor').classList.add("hideDiv");
		document.getElementById('inheritanceFactor').classList.add("hideDiv");
		document.getElementById('couplingFactor').classList.add("hideDiv");
		
	}
	
	

</script>