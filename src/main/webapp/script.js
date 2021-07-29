function createNextInputs() {
    let doorWindowDiv = document.getElementById("construction-container");
    let nextInputContainer = document.createElement("div");
    let nextInputLabel = document.createElement("span");
    nextInputLabel.innerText = "Drzwi / Okno ";

    let widthInput = document.createElement("input");
    widthInput.placeholder = "Szerokość";
    widthInput.name = "width";
    let heightInput = document.createElement("input");
    heightInput.placeholder = "Wysokość";
    heightInput.name = "height";

    nextInputContainer.append(nextInputLabel);
    nextInputContainer.append(widthInput);
    nextInputContainer.append(heightInput);
    doorWindowDiv.prepend(nextInputContainer);
}

function getConstructionElementsNumber() {
    let constructionElementsInput = document.getElementById("construction-elements");
    return constructionElementsInput.value;
}

//przeglądarka nie odświeża zmian wprowadzonych w intelijj w kodzie js - rozwiązanie ⬋
https://www.programmersought.com/article/88712823207/

function incrementCutElements() {
    let constructionElementsInput = document.getElementById("construction-elements");
    constructionElementsInput.value++;
}

function addDoorOrWindowInput() {
    createNextInputs();
    incrementCutElements();
}

function registerAddButton() {
    let addButton = document.getElementById("add-button");
    addButton.onclick = () => addDoorOrWindowInput();
}

registerAddButton();