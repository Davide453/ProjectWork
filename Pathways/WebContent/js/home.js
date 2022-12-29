var typed;

function autoType() {
    typed = new Typed('.auto-type', {
        strings: ["raticità","erfezione","athways"],
        smartBackspace: true,
        typeSpeed: 150,
        backSpeed: 150,
        loop: true,
        showCursor: true,
    })
}

window.onload = function() {
    autoType();
}

