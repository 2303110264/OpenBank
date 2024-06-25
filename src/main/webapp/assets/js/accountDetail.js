$(document).ready(function(){
    	var endDate = document.getElementById("endDate");
    	var startDate = document.getElementById("startDate");
        var today = new Date();

        let fm = function(today){
            var year = today.getFullYear();
            var month = today.getMonth() + 1; // 월이 0부터 시작함
            var day = today.getDate();
 			
            if (month < 10) {
                month = "0" + month;
            }
            if (day < 10) {
                day = "0" + day;
            }
        	return year + "-" + month + "-" + day;
		}
        endDate.value = fm(today);
        today.setMonth(today.getMonth() - 1);
        startDate.value = fm(today);
    	
    	
    	document.getElementById('btn1').addEventListener('click', function() {
    		$('#staticBackdrop').modal('show');
        });
		var ing = true;
    	$('#form').on('submit', function(e){
    		if(!ing) return true;
    		e.preventDefault();
    		var cp = $('#credit-password').val();
    		if(cp!='' && ing){
	    		$.ajax({
	                type: 'POST',
	                url: '/ob/member/credit-password',
	                data: { creditPassword: cp },
	                success: function(result) {
	                	if(result){
	                		console.log("success")
	                		$('#form').submit();
	                		ing=false;
	                		return true;
	                	}
	                	else alert('비밀번호가 맞지 않습니다.')
	                }, error: function(error) {
	                    alert('잘못된 요청입니다');
	                    console.error(error);
	                }
	            });
    		}else{
    			alert("결제 비밀번호를 입력해주세요")
    			$('#credit-password').focus()
    		}
		});
		let pg = 1;
		$('#searchBtn').click(function() {
			let stD = document.getElementById("startDate").value;
			let enD = document.getElementById("endDate").value;
			let params = new URLSearchParams({
					accNum : acc
					, startDate : stD
					, endDate : enD
					, page : pg
			})
			
			fetch('/ob/api/account/transaction?'+params, {
				mode: 'cors'
			})
			.then(function(response) {
				console.log(response)
				return response.json()
			}).then(getTran)
			
			
		})
});
let getTran = function(result) {
		console.log(result)
		let list = result.transaction;
		let size = result.size;
		pg+=1;
		if(size==0) return;
		for(let tran of list) {
			console.log(tran)
			/*let rank = tran;
			let date = tran.date;
			
			$('#resultView').append('<h4>' + rank + '위</h4>')
			$('#resultView').append('<strong>' + movieName + '</strong>')
			$*/('#resultView').append('<hr>')
		}
	} 