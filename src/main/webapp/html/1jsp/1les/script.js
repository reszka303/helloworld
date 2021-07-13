function printWelcomeAndName() {
    let welcome = document.getElementById("welcome").innerHTML = "Witaj Jan Kowalski!";
    console.log(welcome);
}
printWelcomeAndName();

function createArticleAndNumber() {
    let lines = [];
    let number = 0;
    let text = "Paragraf numer ";
    for (let i = 0; i < 5; i++) {
        lines.push(text + number);
        number++;
    }
    console.log(lines);
    //Javascript Vertical Array
    https://stackoverflow.com/questions/31151854/javascript-vertical-array
        document.getElementById("article").innerHTML = lines.join("<br><br>");
}
createArticleAndNumber();






