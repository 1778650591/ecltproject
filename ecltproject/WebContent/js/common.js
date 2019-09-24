//页面跳转后定位到相应的模块
function getSectionTop(elem){
    var arr = [];
    var imgSrc = [];
    var imgs = []; 
    var c = 0;
    $('img').each(function(i,el){
        imgSrc.push($(el).attr('src'));
    });
    for (var i = 0; i < imgSrc.length; i++) {
        imgs[i] = new Image();
        imgs[i].src = imgSrc[i];
        imgs[i].onload = function(){
            c++
            if(c == imgSrc.length){
                $(elem).each(function(i,el){
                    var top = $(el).offset().top - $('#hd').outerHeight();
                    var Index = getSectionNum('section=');
                    arr.push(top);
                    $('html,body').animate({scrollTop:arr[Index]},400);
                })
            }
        }
    }
}

//获取跳转页面后要定位的模块索引值
function getSectionNum(str){
    var href = window.location.href;
    var num = href.split(str)[1]-1;
    if(num==undefined||href.indexOf(str)==-1){
        return 0
    }else{
        return parseInt(num);
    }
    
}

$(function(){

    new WOW().init();

    //页面滚动改变顶部样式
    $(window).on('scroll',function(){
        var top = $(this).scrollTop();
        top>0?$('#hd').addClass('black'):$('#hd').removeClass('black');
    });

    //pc端导航下拉
    $('.hd-nav li').hover(function(){
        $(this).find('.drop').stop().slideDown();
    },function(){
        $(this).find('.drop').slideUp();
    });

    //移动端侧拉菜单控制
    $('.nav-btn').on('click',function(e){
        e.stopPropagation();
        $('.side-menu').toggleClass('side-menu-show');
        $('.search-box').slideUp();
    });
    $('body').on('click',function(){
        $('.side-menu').removeClass('side-menu-show');
        $('.search-box').slideUp();
    });
    $('.side-menu').on('click',function(e){
        e.stopPropagation();
    });

    $('.side-menu h3 i').on('click',function(){
        $(this).parent().toggleClass('on');
        $(this).parents('li').siblings().find('h3').removeClass('on');
        $(this).parent().next().slideToggle();
        $(this).parents('li').siblings().find('.drop').slideUp();
    })

    //搜索框控制
    $('.search-btn').on('click',function(e){
        e.stopPropagation();
        $('.search-box').slideToggle();
        $('.side-menu').removeClass('side-menu-show');
    });
    $('.search-box').on('click',function(e){
        e.stopPropagation();
    });

    //底部分享
    $('#ftShare').share({sites: ['wechat','linkedin', 'facebook', 'twitter']});

})