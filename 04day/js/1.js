var displayImgTime;

function init() {
	setInterval("changeImg()", 3000);
	displayImgTime = setInterval("displayImg()", 3000);
}
var i = 0;

function changeImg() {
	i++;
	document.getElementById("img1").src = "img/" + i + ".jpg";
	if(i == 3)
		i = 0;
}

function displayImg() {
	document.getElementById("img2").style.display = "block";
	clearInterval(displayImgTime);
	setInterval("hiddenImg()", 3000);
}

function hiddenImg() {
	document.getElementById("img2").style.display = "none";
	clearInterval(displayImgTime);
}