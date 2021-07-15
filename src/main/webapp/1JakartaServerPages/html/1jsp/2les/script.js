function createH1() {
    document.getElementById("h1").innerHTML = "JSP with Java Code";
}
createH1();

function createList() {
    let lines = [];
    let iterations = 10;
    let text = "Element no ";
    let number = 0;
    for (let i = 0; i < iterations; i++) {
        //how to avoid a new line with p tag?
        https://stackoverflow.com/questions/2076109/how-to-avoid-a-new-line-with-p-tag
        lines.push("<li><span id='text'>" + text + "</span>" + "<span id='number' typeof='number'>"
            + number + "</span></li>");
        number++;
    }
    document.getElementById("list").innerHTML = lines.join("");
}
createList();