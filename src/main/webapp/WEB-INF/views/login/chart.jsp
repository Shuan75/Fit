<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<link href="../css/noticestyle.css" rel="stylesheet" type="text/css">
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.esm.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.esm.min.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/chart.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/helpers.esm.js'></script>
<script
	src='https://cdnjs.cloudflare.com/ajax/libs/Chart.js/3.8.0/helpers.esm.min.js'></script>


<style>
section {
	display: -webkit-flex;
	display: flex;
}

article {
	-webkit-flex: 3;
	-ms-flex: 3;
	flex: 3;
	padding: 10px;
}
</style>

<section class="mypage">

	<nav>
		<div id="navigation">
			<div class="snb">
				<h2>마이페이지</h2>
				<ul>
					<li><a href="#" onclick="location.href='modify.do?id=${s_id}'">회원정보수정</a></li>
					<li><a href="#" onclick="location.href='calendar.do'">달력</a></li>
					<li><a href="#" onclick="location.href='chart.do'">차트</a></li>
					<li><a href="#" onclick="location.href='pay.do'">결제</a></li>
					<li><a href="#" onclick="location.href='chat.do'">온라인강의</a></li>
					
				</ul>
			</div>
		</div>
	</nav>
	<article>
		<canvas id="myChart" width="400" height="400"></canvas>

		<script>
		/* var chartLabels = [];

		var chartData = [];



		$.getJSON("http://localhost:9098/chart.do", function(data){

			

			$.each(data, function(inx, obj){

				chartLabels.push(obj.dd);

				chartData.push(obj.income);

			});

			createChart();

			console.log("myChart")

		});
		var lineChartData = {

				labels : chartLabels,

				datasets : [

					{

						label : "Date Income",

						fillColor : "rbga(151,187,205,0.2)",

						strokeColor : "rbga(151,187,205,1)",

						pointColor : "rbga(151,187,205,1)",

						pointStrokeColor : "#fff",

						pointHighlightFill : "#fff",

						pointHighlightStroke : "rbga(151,187,205,1)",

						data : chartData

					

				}

					]

		}



		function createChart(){

			var ctx = document.getElementById("myChart").getContext("2d");

			LineChartDemo = Chart.Line(ctx,{

				data : lineChartData,

				options :{

					scales : {

						yAxes : [{

							ticks :{

								beginAtZero : true

							}

						}]

					}

				}

			})



		} */
			 const ctx = document.getElementById('myChart').getContext('2d');
			const myChart = new Chart(ctx, {
				type : 'radar',
				data : {
					labels: [
					    '수면욕',
					    '의욕',
					    '지식수준',
					    '완성확률',
					    '할일많음',
					    '남은시간',
					    '디비랑연동해야함'
					  ],
					  datasets: [{
					    label: '조커는 두 장밖에 없는 줄 알았는데, 너라는 패도 있군',
					    data: [65, 59, 90, 81, 56, 55, 40],
					    fill: true,
					    backgroundColor: 'rgba(255, 99, 132, 0.2)',
					    borderColor: 'rgb(255, 99, 132)',
					    pointBackgroundColor: 'rgb(255, 99, 132)',
					    pointBorderColor: '#fff',
					    pointHoverBackgroundColor: '#fff',
					    pointHoverBorderColor: 'rgb(255, 99, 132)'
					  }, 
					  {
					    label: '파랑이 좋겠어',
					    data: [28, 48, 40, 19, 96, 27, 100],
					    fill: true,
					    backgroundColor: 'rgba(54, 162, 235, 0.2)',
					    borderColor: 'rgb(54, 162, 235)',
					    pointBackgroundColor: 'rgb(54, 162, 235)',
					    pointBorderColor: '#fff',
					    pointHoverBackgroundColor: '#fff',
					    pointHoverBorderColor: 'rgb(54, 162, 235)'
					  }]
				},
				options : {
					scales : {
						y : {
							beginAtZero : true
						}

					}
				}
			}); 
		</script>
	</article>
</section>

<%@ include file="../footer.jsp"%>
