var $url = window.location.pathname;
var $items;

function AddItem(name, description) {
    var JSONObject = {'name': name, 'description': description};
    $.ajax({
        type: 'POST',
        url: $url + 'item/add',
        contentType: 'application/json',
        data: JSON.stringify(JSONObject),
        async: false
    });
}

function GetAllItems() {
    $.ajax({
        type: 'GET',
        url: $url + 'item/getAll',
        async: false,
        success: function (itemList) {
            $items = itemList;
            FillTableItems();
        }
    });
}

function FillTableItems() {
    var $tableItem = $('#table');
    $tableItem.find('.removable').remove();
    $.each($items, function (index, item) {
        var $tr = $('<tr>').appendTo($tableItem);
        $tr.addClass("removable");
        if (item.done === true) {
            $tr.addClass("isDone");
        }
        $('<td>').addClass('itemId').text(item.id).appendTo($tr);
        $('<td>').addClass('itemName').text(item.name).appendTo($tr);
        $('<td>').addClass('itemDesc').text(item.description).appendTo($tr);
        $('<td>').addClass('itemCreated').text(item.created).appendTo($tr);
        $('<td>').addClass('itemDone').text(item.done).appendTo($tr);
        $('<button>').addClass('finishItem').text('finish').appendTo($tr);
    })
    HideIsDone();
    Finish();
}

function HideIsDone() {
    var $showAll = $('#isDone').prop('checked');
    if (!$showAll) {
        $('.isDone').hide();
    } else {
        $('.isDone').show();
    }
}

function Finish() {
    $('.finishItem').click(function () {
        var $tr = $(this).closest('tr');
        var itemId = $tr.find('.itemId').text();
        var itemName = $tr.find('.itemName').text();
        var itemDesc = $tr.find('.itemDesc').text();
        var itemCreated = $tr.find('.itemCreated').text();
        var jsonItem = {'id': itemId, 'name': itemName, 'description': itemDesc, 'created': itemCreated, 'done': true};
        $.ajax({
            type: "POST",
            url: $url + "item/update",
            contentType: "application/json",
            data: JSON.stringify(jsonItem),
            async: false,
            success: function () {
                GetAllItems();
            }
        });
    });
}