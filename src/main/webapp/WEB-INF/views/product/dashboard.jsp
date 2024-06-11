<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- SB Admin 2 CSS -->
    <link href="${path}/assets/sb-admin-2/css/sb-admin-2.min.css" rel="stylesheet">
    <!-- Font Awesome Icons -->
    <link href="<https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css>" rel="stylesheet">
    <!-- Google Fonts -->
    <link href="<https://fonts.googleapis.com/css?family=Nunito:200,300,400,600,700,800,900>" rel="stylesheet">
</head>
<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">
            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="${path}/bank">
                <div class="sidebar-brand-text mx-3">OpenBank Admin</div>
            </a>
            <!-- Divider -->
            <hr class="sidebar-divider my-0">
            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="${path}/product/admin/dashboard">
                    <i class="fas fa-fw fa-tachometer-alt"></i>
                    <span>Dashboard</span></a>
            </li>
            <!-- Nav Item - Product List -->
            <li class="nav-item">
                <a class="nav-link" href="${path}/product/admin/list">
                    <i class="fas fa-fw fa-list"></i>
                    <span>Product List</span></a>
            </li>
        </ul>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">
            <!-- Main Content -->
            <div id="content">
                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">
                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>
                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">Admin</span>
                                <img class="img-profile rounded-circle" src="<https://startbootstrap.github.io/startbootstrap-sb>

-admin-2/img/undraw_profile.svg">
                            </a>
                        </li>
                    </ul>
                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">
                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">Dashboard</h1>
                    </div>
                    <!-- Content Row -->
                    <div class="row">
                        <!-- Total Users Card -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                전체 이용자 수</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><c:out value="${totalUsers}"/></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-users fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- New Subscribers Card -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                상품 신규 가입자</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><c:out value="${newSubscribers}"/></div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-user-plus fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Total Deposit Card -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                                전체 입금액</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><c:out value="${totalDeposit}"/> 원</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-coins fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- Total Withdraw Card -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                전체 출금액</div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800"><c:out value="${totalWithdraw}"/> 원</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-money-bill-wave fa-2x text-gray-300"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- User Trends Line Chart -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">신규 이용자 추이</h6>
                                </div>
                                <div class="card-body">
                                    <div class="chart-area">
                                        <canvas id="userTrendsChart"></canvas>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- Product Statistics Table -->
                    <div class="row">
                        <div class="col-12">
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">상품별 통계</h6>
                                </div>
                                <div class="card-body">
                                    <div class="table-responsive">
                                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
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
                                                        <td><c:out value="${stat.productNum}"/></td>
                                                        <td><c:out value="${stat.productName}"/></td>
                                                        <td><c:out value="${stat.subscriberCount}"/></td>
                                                        <td><c:out value="${stat.totalDeposit}"/> 원</td>
                                                        <td><c:out value="${stat.totalWithdraw}"/> 원</td>
                                                        <td><c:out value="${stat.newSubscribers}"/></td>
                                                    </tr>
                                                </c:forEach>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /.container-fluid -->
            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>&copy; 2024 OpenBank Admin. All rights reserved.</span>
                    </div>
                </div>
            </footer>
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
    <script src="<https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js>"></script>
    <script src="<https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.6.0/js/bootstrap.bundle.min.js>"></script>

    <!-- Core plugin JavaScript-->
    <script src="<https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.4.1/jquery.easing.min.js>"></script>

    <!-- SB Admin 2 JavaScript-->
    <script src="${path}/assets/sb-admin-2/js/sb-admin-2.min.js"></script>

    <!-- Chart.js -->
    <script src="<https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.9.4/Chart.min.js>"></script>

    <!-- Custom scripts for the chart -->
    <script>
        $(document).ready(function() {
            var ctx = document.getElementById('userTrendsChart').getContext('2d');
            var userTrendsChart = new Chart(ctx, {
                type: 'line',
                data: {
                    labels: [
                        <c:forEach var="trend" items="${userTrends}">
                            '<c:out value="${trend.date}"/>',
                        </c:forEach>
                    ],
                    datasets: [{
                        label: '신규 이용자 수',
                        data: [
                            <c:forEach var="trend" items="${userTrends}">
                                <c:out value="${trend.newUserCount}"/>,
                            </c:forEach>
                        ],
                        backgroundColor: 'rgba(78, 115, 223, 0.05)',
                        borderColor: 'rgba(78, 115, 223, 1)',
                        pointRadius: 3,
                        pointBackgroundColor: 'rgba(78, 115, 223, 1)',
                        pointBorderColor: 'rgba(78, 115, 223, 1)',
                        pointHoverRadius: 3,
                        pointHoverBackgroundColor: 'rgba(78, 115, 223, 1)',
                        pointHoverBorderColor: 'rgba(78, 115, 223, 1)',
                        pointHitRadius: 10,
                        pointBorderWidth: 2
                    }]
                },
                options: {
                    maintainAspectRatio: false,
                    layout: {
                        padding: {
                            left: 10,
                            right: 25,
                            top: 25,
                            bottom: 0
                        }
                    },
                    scales: {
                        xAxes: [{
                            time: {
                                unit: 'date'
                            },
                            gridLines: {
                                display: false,
                                drawBorder: false
                            },
                            ticks: {
                                maxTicksLimit: 7
                            }
                        }],
                        yAxes: [{
                            ticks: {
                                maxTicksLimit: 5,
                                padding: 10
                            },
                            gridLines: {
                                color: 'rgb(234, 236, 244)',
                                zeroLineColor: 'rgb(234, 236, 244)',
                                drawBorder: false,
                                borderDash: [2],
                                zeroLineBorderDash: [2]
                            }
                        }]
                    },
                    legend: {
                        display: false
                    },
                    tooltips: {
                        backgroundColor: 'rgb(255, 255, 255)',
                        bodyFontColor: '#858796',
                        titleFontColor: '#6e707e',
                        titleMarginBottom: 10,
                        titleFontSize: 14,
                        borderColor: '#dddfeb',
                        borderWidth: 1,
                        xPadding: 15,
                        yPadding: 15,
                        displayColors: false,
                        intersect: false,
                        mode: 'index',
                        caretPadding: 10
                    }
                }
            });
        });
    </script>
</body>
</html>
