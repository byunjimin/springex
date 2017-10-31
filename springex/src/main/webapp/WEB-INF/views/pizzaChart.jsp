<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <!--Load the AJAX API-->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
	//1.문서로딩	
    $(document).ready(function(){
    	//2.ajax 요청
    	$.ajax({
    		type:'GET',
    		url:'/web/pizzaChart',
    		//3. 요청 성공
    		success:function(json){
    			//4. 구글차트 로딩
    			google.charts.load('current', {'packages':['corechart']});
    			 //5. 구글차트 그리기 
    			google.charts.setOnLoadCallback(function(){
    				 var data = new google.visualization.DataTable();
    			     data.addColumn('string', 'topping');
    			     data.addColumn('number', 'slices');
    			     var rowList = new Array();
    			     $(json).each(function(){
    			    	 var row = [];
    			    	 row[0] = this.topping;
    			    	 row[1] = this.slices;
    			    	 rowList.push(row);
    			     });
    			     data.addRows(rowList);

    			        // Set chart options
    			        var options = {'title':'How Much Pizza I Ate Last Night',
    			                       'width':400,
    			                       'height':300};

    			        // Instantiate and draw our chart, passing in some options.
    			        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
    			        chart.draw(data, options);
    			      
    			 });
    		}
    		
    	});
    });
    /*
      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Mushrooms', 3],
          ['Onions', 1],
          ['Olives', 1],
          ['Zucchini', 1],
          ['Pepperoni', 2]
        ]);

        // Set chart options
        var options = {'title':'How Much Pizza I Ate Last Night',
                       'width':400,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
      */
    </script>
  </head>

  <body>
    <!--Div that will hold the pie chart-->
    <div id="chart_div"></div>
  </body>
</html>