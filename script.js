function showContent(contentId) {
    var contents = document.getElementsByClassName('content');
    for (var i = 0; i < contents.length; i++) {
        contents[i].classList.add('hidden');
    }
    document.getElementById(contentId).classList.remove('hidden');
}

function toggleDetails(detailsId) {
    var details = document.getElementById(detailsId);
    if (details.classList.contains('hidden')) {
        details.classList.remove('hidden');
    } else {
        details.classList.add('hidden');
    }
}

function addJobOffer() {
    var companyNumber = document.getElementById('companyNumber').value;
    var companyAddress = document.getElementById('companyAddress').value;
    var interviewDate = document.getElementById('interviewDate').value;
    var phone = document.getElementById('phone').value;
    var natureOfWork = document.getElementById('natureOfWork').value;
    var workType = document.getElementById('workType').value;

    var table = document.getElementById('jobOffersTable').getElementsByTagName('tbody')[0];
    var newRow = table.insertRow();

    newRow.insertCell(0).innerText = companyNumber;
    newRow.insertCell(1).innerText = companyAddress;
    newRow.insertCell(2).innerText = interviewDate;
    newRow.insertCell(3).innerText = phone;
    newRow.insertCell(4).innerText = natureOfWork;
    newRow.insertCell(5).innerText = workType;
    var actionsCell = newRow.insertCell(6);
    var deleteButton = document.createElement('button');
    deleteButton.innerText = 'Delete';
    deleteButton.onclick = function() {
        table.deleteRow(newRow.rowIndex - 1);
        updateJobOfferCount();
    };
    actionsCell.appendChild(deleteButton);

    updateJobOfferCount();

    document.getElementById('jobOfferForm').reset();
}

function updateJobOfferCount() {
    var table = document.getElementById('jobOffersTable').getElementsByTagName('tbody')[0];
    document.getElementById('jobOfferCount').innerText = 'Total Job Offers: ' + table.rows.length;
}

function printJobOffers() {
    window.print();
}