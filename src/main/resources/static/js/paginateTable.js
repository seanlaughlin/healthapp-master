//Source: https://stackoverflow.com/questions/25434813/simple-pagination-in-javascript, http://jsfiddle.net/Lzp0dw83/
//Modified by Sean Laughlin

let data;
let next;
let prev;
let pageNoSpan;
let table;

let current_page = 1;
let records_per_page;

function addEntryToTable(entry) {
    if(!(data[data.length-1]==today.toLocaleDateString('en-GB'))){
        data.push(entry);
        //Refreshes table entries
        changePage(1);
        return true;
    }
        return false;
}

function setupTable(dataIn, nextBtn, prevBtn, pageNoEl, tableEl, recordsPerPage) {
    data = dataIn;
    next = nextBtn;
    prev = prevBtn;
    pageNoSpan = pageNoEl;
    table = tableEl;
    records_per_page = recordsPerPage;
}


function prevPage() {
    if (current_page > 1) {
        current_page--;
        changePage(current_page);
    }
}

function nextPage() {
    if (current_page < numPages()) {
        current_page++;
        changePage(current_page);
    }
}

function changePage(page) {

    if (page < 1) page = 1;
    if (page > numPages()) page = numPages();
    table.innerHTML = "";

    let j = 0;
    for (var i = (page - 1) * records_per_page; i < (page * records_per_page); i++) {
        if(i < data.length){
        //Error occurs on last page if number of results is less than page size. Until solution is found, this try catch prevents issues
            let row = table.insertRow(j);
            let cell1 = row.insertCell(0);
            let cell2 = row.insertCell(1);
            cell1.innerHTML = new Date(data[i].x).toLocaleDateString('en-GB');
            cell2.innerHTML = data[i].y;
            j++;
        }
    }
    let numberOfPages = numPages();
    pageNoSpan.innerHTML = `${page}/${numberOfPages}`;

    if (page == 1) {
        prev.style.visibility = "hidden";
    } else {
        prev.style.visibility = "visible";
    }

    if (page == numPages()) {
        btn_next.style.visibility = "hidden";
    } else {
        btn_next.style.visibility = "visible";
    }
}

function numPages() {
    return Math.ceil((Object.keys(data).length / records_per_page));
}

window.onload = function () {
    changePage(1);
};