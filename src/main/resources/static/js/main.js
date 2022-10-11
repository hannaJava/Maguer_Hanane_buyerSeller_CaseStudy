/** function to display existion items with qt>0 inside a table */
function displayItems(){
    var list = [1,2,3,4,5];
    var items = ['laptop','desktop','tablette','cell phone','Monitor'];
    var prices = [700,500,300,400,200];
    var amount=[2,1,0,3,5];
     for (var i = 0; i < list.length; i++) {
        if(amount[i]!=0){
        var div_container1 = document.createElement('tr');
        var div_container2 = document.createElement('td');
        div_container2.style.margin="5px"
        div_container2.textContent = items[i];
        var div_container3 = document.createElement('td');
        div_container3.textContent = prices[i];
        var div_container4 = document.createElement('td');
        div_container4.textContent = amount[i];
        var element = document.getElementById("id-table");
        div_container1.appendChild(div_container2);
        div_container1.appendChild(div_container3);
        div_container1.appendChild(div_container4);
        element.appendChild(div_container1);
        }
    }  
}

/**function to display table */
function showTable(){
    var table = document.getElementById("id-table");
    table.style.display='block';
}

/**first slider */
    $(".slider-one").slick();/**
 * 
 */