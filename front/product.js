function addProduct() {
    let productName =  document.getElementById('productName').value;
    productNames[step] = productName;
    select = document.getElementById('selectProduct');
    let option = document.createElement('option');
    option.innerText = productName;
    option.className = 'option';
    option.onclick =
    select.appendChild(option);
    PopUpHide();
    deployConract(productName);
}

function track(){

    let contract = openContract();
    getStates(contract);

}