var typed;

function autoType() {
    typed = new Typed('.auto-type', {
        strings: ["athways", "erformance", "recision"],
        smartBackspace: true,
        typeSpeed: 150,
        backSpeed: 150,
        loop: true,
        showCursor: true,
    })
}

function scrollAnimation() {
    const track = document.getElementById("image-track");

    const handleOnDown = e => track.dataset.mouseDownAt = e.clientX;

    const handleOnUp = () => {
        track.dataset.mouseDownAt = "0";
        track.dataset.prevPercentage = track.dataset.percentage;
    }

    const handleOnMove = e => {
        if (track.dataset.mouseDownAt === "0") return;

        const mouseDelta = parseFloat(track.dataset.mouseDownAt) - e.clientX,
            maxDelta = window.innerWidth / 2;

        const percentage = (mouseDelta / maxDelta) * -100,
            nextPercentageUnconstrained = parseFloat(track.dataset.prevPercentage) + percentage,
            nextPercentage = Math.max(Math.min(nextPercentageUnconstrained, 0), -100);

        track.dataset.percentage = nextPercentage;

        track.animate({
            transform: `translate(${nextPercentage}%, -50%)`
        }, { duration: 1500, fill: "forwards" });

        for (const image of track.getElementsByClassName("image")) {
            image.animate({
                objectPosition: `${100 + nextPercentage}% center`
            }, { duration: 1500, fill: "forwards" });
        }
    }

    /* -- Touch events -- */

    window.onmousedown = e => handleOnDown(e);

    window.ontouchstart = e => handleOnDown(e.touches[0]);

    window.onmouseup = e => handleOnUp(e);

    window.ontouchend = e => handleOnUp(e.touches[0]);

    window.onmousemove = e => handleOnMove(e);

    window.ontouchmove = e => handleOnMove(e.touches[0]);
}


function changeColourOnScroll() {
    // seleziona l'elemento #target
    var target = $('#target-navbar');

    // se l'elemento esiste
    if (target.length) {
        // calcola l'altezza dell'elemento #target dall'inizio della pagina
        var targetTop = target.offset().top;

        // quando si scorre la pagina
        $(window).scroll(function () {
            // calcola l'altezza attuale della finestra di visualizzazione dall'inizio della pagina
            var windowTop = $(window).scrollTop();

            // se l'altezza attuale della finestra di visualizzazione è maggiore o uguale dell'altezza dell'elemento #target
            if (windowTop >= targetTop) {
                // cambia il colore del navbar
                $('nav').css('background-color', 'red');
            } else {
                // altrimenti, ripristina il colore originale del navbar
                $('nav').css('background-color', '');
            }
        });
    }
}

function buttonToTop() {
    var btn = $('#button');

    $(window).scroll(function () {
        if ($(window).scrollTop() > 300) {
            btn.addClass('show');
        } else {
            btn.removeClass('show');
        }
    });

    btn.on('click', function (e) {
        e.preventDefault();
        $('html, body').animate({ scrollTop: 0 }, '300');
    });
}



window.onload = function () {
	
	buttonToTop();
    autoType();
    scrollAnimation();
    changeColourOnScroll();

    $(".box-video").click(function () {
        $('iframe', this)[0].src += "&amp;autoplay=1";
        $(this).addClass('open');
    });

}


