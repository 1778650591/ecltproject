$(document).ready(function(){
	
	$('.click_sjnav').click(function(){

		$(this).parents('.header').find('.navslider_sj').stop().slideToggle(200);
	});
	
	$('.Englishzw').click(function(){

		$(this).toggleClass('cur');
	});
	
	$('.fenlbar_bank ul li').hover(function(){

		var len_1=$(this).index();
		var len_2=$(this).parents('.main_randcp').find('.felbank_slider .felrandbar').index();
		len_2=len_1;
		$(this).addClass('active').siblings().removeClass('active');
		$(this).parents('.main_randcp').find('.felbank_slider .felrandbar').eq(len_2).addClass('active').siblings().removeClass('active');
	});


	function IsPC() {
        var userAgentInfo = navigator.userAgent;
        var Agents = ["Android", "iPhone",
                    "SymbianOS", "Windows Phone",
                    "iPad", "iPod"];
        var flag = true;
        for (var v = 0; v < Agents.length; v++) {
            if (userAgentInfo.indexOf(Agents[v]) > 0) {
                flag = false;
                break;
            }
        }
        return flag;
    };
    $(document).ready(function(){
        var isPC=IsPC();
        if(isPC){
           $(window).scroll(function() {
	    	
			var nowt = $(window).scrollTop();
			
			if (nowt>60) {
				$('.header').css('padding-top', 0);
				$('.header').css('top', 50);
			}else{
				$('.header').css('padding-top', 60);
				$('.header').css('top', 0);
			}

	    	});
           $('.colse_mains a').click(function(){

		$(this).parents('.findextanc').css('visibility', 'hidden');;
		});
		$('.Anlislider ul li').click(function(){

			$('.findextanc').css('visibility', 'visible');;
		});
		$('.felrandbar ul li').click(function(){

			$('.findextanc').css('visibility', 'visible');;
		});
		$('.renshlisrt .swiper-slide').click(function(){

			$('.findextanc').css('visibility', 'visible');;
		});
	      }
        else{
           
        }
    });



});