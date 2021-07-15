function getVideo() {
    let iframeVideo = "<iframe width='640' height='340' src='https://www.youtube.com/embed/tAGnKpE4NCI'></iframe>"
    let getId = document.getElementById("ytplayer");
    getId.innerHTML = iframeVideo;
//<iframe width="640" height="340" src="https://www.youtube.com/embed/tAGnKpE4NCI" ></iframe>

}
getVideo();
