
$(document).ready(function(){
    var windowWidth = $(window).width();
    if(windowWidth<1280){
        var b,c1,c2,c3,c4,c5,c6;
        //a = $(window).height();    //浏览器窗口高度
        var group1 = $(".group1block");
        var group2 = $(".group2block");
        var group3 = $(".group3block");
        var group4 = $(".group4block");
        var group5 = $(".group5block");
        var group6 = $(".group6block");
        b = $(this).scrollTop();   //页面滚动的高度
        c1 = group1.offset().top;    //元素距离文档（document）顶部的高度
        c2 = group2.offset().top;
        c3 = group3.offset().top;
        c4 = group4.offset().top;
        c5 = group5.offset().top;
        c6 = group6.offset().top;
        // console.log(c5-b);
        if (c1-b){
            $('.group1block1').addClass("animated fadeInUp");
            $('.group1block2').addClass("animated fadeInUp");
            $('.group1block3').addClass("animated fadeInUp");
            $('.group1block4').addClass("animated fadeInUp");
            $('.group1block5').addClass("animated fadeInUp");
            $('.group1block6').addClass("animated fadeInUp");
        }
        if (c2-b<567){
            $('.group2block1').addClass("animated fadeInUp");
            $('.group2block2').addClass("animated fadeInLeft");
            $('.group2block3').addClass("animated fadeInRight");
        }
        if (c3-b<567){
            $('.group3block1').addClass("animated fadeInLeft");
            $('.group3block2').addClass("animated fadeInRight");
            $('.group3block3').addClass("animated fadeInUp");
        }
        if (c4-b<567){
            $('.group4block1').addClass("animated fadeInUp");
            $('.group4block2').addClass("animated fadeInLeft");
            $('.group4block3').addClass("animated fadeInLeft");
            $('.group4block4').addClass("animated fadeInRight");
            $('.group4block5').addClass("animated fadeInRight");
        }
        if (c5-b<567){
            $('.group5block1').addClass("animated fadeInUp");
            $('.group5block2').addClass("animated fadeInLeft");
            $('.group5block3').addClass("animated fadeInLeft");
            $('.group5block4').addClass("animated fadeInRight");
            $('.group5block5').addClass("animated fadeInRight");
            $('.group5block6').addClass("animated fadeInUp");
        }
        if (c6-b<567){
            $('.group6block1').addClass("animated fadeInUp");
        }
        $(window).scroll(function(){
            b = $(this).scrollTop();   //页面滚动的高度
            c1 = group1.offset().top;    //元素距离文档（document）顶部的高度
            c2 = group2.offset().top;
            c3 = group3.offset().top;
            c4 = group4.offset().top;
            c5 = group5.offset().top;
            c6 = group6.offset().top;
            if (c2-b<567){
                $('.group2block1').addClass("animated fadeInUp");
                $('.group2block2').addClass("animated fadeInLeft");
                $('.group2block3').addClass("animated fadeInRight");
            }
            if (c3-b<567){
                $('.group3block1').addClass("animated fadeInLeft");
                $('.group3block2').addClass("animated fadeInRight");
                $('.group3block3').addClass("animated fadeInUp");
            }
            if (c4-b<567){
                $('.group4block1').addClass("animated fadeInUp");
                $('.group4block2').addClass("animated fadeInLeft");
                $('.group4block3').addClass("animated fadeInLeft");
                $('.group4block4').addClass("animated fadeInRight");
                $('.group4block5').addClass("animated fadeInRight");
            }
            if (c5-b<567){
                $('.group5block1').addClass("animated fadeInUp");
                $('.group5block2').addClass("animated fadeInLeft");
                $('.group5block3').addClass("animated fadeInLeft");
                $('.group5block4').addClass("animated fadeInRight");
                $('.group5block5').addClass("animated fadeInRight");
                $('.group5block6').addClass("animated fadeInUp");
            }
            if (c6-b<567){
                $('.group6block1').addClass("animated fadeInUp");
            }
        });
    }else{
        var b,c1,c2,c3,c4,c5,c6;
        //a = $(window).height();    //浏览器窗口高度
        var group1 = $(".group1block");
        var group2 = $(".group2block");
        var group3 = $(".group3block");
        var group4 = $(".group4block");
        var group5 = $(".group5block");
        var group6 = $(".group6block");
        b = $(this).scrollTop();   //页面滚动的高度
        c1 = group1.offset().top;    //元素距离文档（document）顶部的高度
        c2 = group2.offset().top;
        c3 = group3.offset().top;
        c4 = group4.offset().top;
        c5 = group5.offset().top;
        c6 = group6.offset().top;
         console.log(c2-b);
        if (c1-b){
            $('.group1block1').addClass("animated fadeInUp");
            $('.group1block2').addClass("animated fadeInUp");
            $('.group1block3').addClass("animated fadeInUp");
            $('.group1block4').addClass("animated fadeInUp");
            $('.group1block5').addClass("animated fadeInUp");
            $('.group1block6').addClass("animated fadeInUp");
        }
        if (c2-b<680){
            $('.group2block1').addClass("animated fadeInUp");
            $('.group2block2').addClass("animated fadeInLeft");
            $('.group2block3').addClass("animated fadeInRight");
        }
        if (c3-b<680){
            $('.group3block1').addClass("animated fadeInLeft");
            $('.group3block2').addClass("animated fadeInRight");
            $('.group3block3').addClass("animated fadeInUp");
        }
        if (c4-b<680){
            $('.group4block1').addClass("animated fadeInUp");
            $('.group4block2').addClass("animated fadeInLeft");
            $('.group4block3').addClass("animated fadeInLeft");
            $('.group4block4').addClass("animated fadeInRight");
            $('.group4block5').addClass("animated fadeInRight");
        }
        if (c5-b<680){
            $('.group5block1').addClass("animated fadeInUp");
            $('.group5block2').addClass("animated fadeInLeft");
            $('.group5block3').addClass("animated fadeInLeft");
            $('.group5block4').addClass("animated fadeInRight");
            $('.group5block5').addClass("animated fadeInRight");
            $('.group5block6').addClass("animated fadeInUp");
        }
        if (c6-b<680){
            $('.group6block1').addClass("animated fadeInUp");
        }
        $(window).scroll(function(){
            b = $(this).scrollTop();   //页面滚动的高度
            c1 = group1.offset().top;    //元素距离文档（document）顶部的高度
            c2 = group2.offset().top;
            c3 = group3.offset().top;
            c4 = group4.offset().top;
            c5 = group5.offset().top;
            c6 = group6.offset().top;
            if (c2-b<680){
                $('.group2block1').addClass("animated fadeInUp");
                $('.group2block2').addClass("animated fadeInLeft");
                $('.group2block3').addClass("animated fadeInRight");
            }
            if (c3-b<680){
                $('.group3block1').addClass("animated fadeInLeft");
                $('.group3block2').addClass("animated fadeInRight");
                $('.group3block3').addClass("animated fadeInUp");
            }
            if (c4-b<680){
                $('.group4block1').addClass("animated fadeInUp");
                $('.group4block2').addClass("animated fadeInLeft");
                $('.group4block3').addClass("animated fadeInLeft");
                $('.group4block4').addClass("animated fadeInRight");
                $('.group4block5').addClass("animated fadeInRight");
            }
            if (c5-b<680){
                $('.group5block1').addClass("animated fadeInUp");
                $('.group5block2').addClass("animated fadeInLeft");
                $('.group5block3').addClass("animated fadeInLeft");
                $('.group5block4').addClass("animated fadeInRight");
                $('.group5block5').addClass("animated fadeInRight");
                $('.group5block6').addClass("animated fadeInUp");
            }
            if (c6-b<680){
                $('.group6block1').addClass("animated fadeInUp");
            }
        });
    }
    // alert(windowWidth);

});