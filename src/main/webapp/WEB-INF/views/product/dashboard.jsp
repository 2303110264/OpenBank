<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>관리자 대시보드</title>
    <link href="<c:url value='/assets/dashboard/vendor/fontawesome-free/css/all.min.css' />" rel="stylesheet" type="text/css">
    <link href="<c:url value='/assets/dashboard/css/sb-admin-2.min.css' />" rel="stylesheet">
</head>
<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
        <jsp:include page="/WEB-INF/views/product/sidebar.jsp"></jsp:include>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <jsp:include page="/WEB-INF/views/product/topbar.jsp"></jsp:include>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">관리자 대시보드</h1>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        <!-- 전체 이용자 수 -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                전체 이용자 수</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${totalUsers}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-users fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 신규 가입자 수 -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                신규 가입자 수</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${newSubscribers}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-user-plus fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 전체 입금액 -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                                전체 입금액</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">₩${totalDeposits}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-coins fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- 전체 출금액 -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                전체 출금액</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">₩${totalWithdrawals}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-money-bill-wave fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        <!-- 통계 정보 -->
                        <div class="col-xl-12 col-lg-12">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">상품별 통계</h6>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>상품 번호</th>
                                                    <th>상품명</th>
                                                    <th>가입자 수</th>
                                                    <th>총 입금액</th>
                                                    <th>총 출금액</th>
                                                    <th>신규 가입자 수</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="stat" items="${stats}">
                                                    <tr>
                                                        <td>${stat.PRODUCTNUM}</td>
                                                        <td>${stat.PRODUCTNAME}</td>
                                                        <td>${stat.SUBSCRIBERCOUNT}</td>
                                                        <td>₩${stat.TOTALDEPOSIT}</td>
                                                        <td>₩${stat.TOTALWITHDRAW}</td>
                                                        <td>${stat.NEWSUBSCRIBERS}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Content Row -->
                    <div class="row">

                        <!-- 신규 사용자 추이 -->
                        <div class="col-xl-12 col-lg-12">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">신규 사용자 추이</h6>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" width="100%" cellspacing="0">
                                            <thead>
                                                <tr>
                                                    <th>일자</th>
                                                    <th>신규 가입자 수</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                                <c:forEach var="trend" items="${userTrends}">
                                                    <tr>
                                                        <td>${trend.TRANSACTION_DATE}</td>
                                                        <td>${trend.NEWUSERCOUNT}</td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                    <canvas id="userTrendsChart"></canvas>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <jsp:include page="/WEB-INF/views/product/footer.jsp"></jsp:include>
                        <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Bootstrap core JavaScript-->
    <script src="<c:url value='/assets/dashboard/vendor/jquery/jquery.min.js' />"></script>
    <script src="<c:url value='/assets/dashboard/vendor/bootstrap/js/bootstrap.bundle.min.js' />"></script>

    <!-- Core plugin JavaScript-->
    <script src="<c:url value='/assets/dashboard/vendor/jquery-easing/jquery.easing.min.js' />"></script>

    <!-- Custom scripts for all pages-->
    <script src="<c:url value='/assets/dashboard/js/sb-admin-2.min.js' />"></script>

    <!-- Chart.js -->
    <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>

    <script>
        $(document).ready(function () {
            var ctx = document.getElementById('userTrendsChart').getContext('2d');
            var labels = ['2024-01-01', '2024-02-01', '2024-03-01', '2024-04-01', '2024-05-01'];
            var data = [1, 6, 9, 5, 10];

            var chartData = {
                labels: labels,
                datasets: [{
                    label: '신규 사용자 수',
                    data: data,
                    backgroundColor: 'rgba(54, 162, 235, 0.2)',
                    borderColor: 'rgba(54, 162, 235, 1)',
                    borderWidth: 1
                }]
            };

            var userTrendsChart = new Chart(ctx, {
                type: 'line',
                data: chartData,
                options: {
                    responsive: true,
                    scales: {
                        y: {
                            beginAtZero: true
                        }
                    }
                }
            });
        });
    </script>

</body>

</html>