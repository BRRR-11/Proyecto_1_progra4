
function CalendarClass() {


    var now = new Date();
    var nowYear = now.getFullYear();
    var nowMonth = now.getMonth();
    var nowDay = now.getDate();
    var set = new Date();
    var monthDaysY = new Array('31', '28', '31', '30', '31', '30', '31', '31', '30', '31', '30', '31');
    var monthDaysL = new Array('31', '29', '31', '30', '31', '30', '31', '31', '30', '31', '30', '31');
    //var weekDays = new Array('D','L','M','M','J','V','S');
    var dataFormat = new Array('d', 'm', 'y');
    var dataSeparator = '/';
    this.calendarId = 'calendar' + new Date().getTime();
    this.calendarDays = new Array();
    this.monthNames = new Array('ENE', 'FEB', 'MAR', 'ABR', 'MAY', 'JUN', 'JUL', 'AGO', 'SEP', 'OCT', 'NOV', 'DIC');
    this.inputField = null;

    function $(id) {

        if (typeof id == 'string') {
            var elementObj = (document.getElementById(id)) ? document.getElementById(id) : null;
            if (elementObj != null) {
                return ((typeof (elementObj.type) != 'undefined') || (elementObj.id != null)) ? elementObj : false;
            } else {
                return false;
            }
        } else {
            return id;
        }
    }
    this.objLeft = function (elementObj) {

        var leftDistance = 0;
        if (elementObj.offsetParent) {
            while (elementObj.offsetParent) {
                leftDistance += elementObj.offsetLeft
                elementObj = elementObj.offsetParent;
            }
        } else if (elementObj.x) {
            leftDistance += elementObj.x;
        }
        return leftDistance;
    }
    this.objTop = function (elementObj) {

        var topDistance = 0;
        if (elementObj.offsetParent) {
            while (elementObj.offsetParent) {
                topDistance += elementObj.offsetTop
                elementObj = elementObj.offsetParent;
            }
        } else if (elementObj.y) {
            topDistance += elementObj.y;
        }
        return topDistance;
    }


    this.makeCalendar = function () {

        var selectedYear = set.getFullYear();
        var selectedMonth = set.getMonth();
        var selectedDay = set.getDate();
        var monthsArray = ((selectedYear % 4) == 0) ? monthDaysL : monthDaysY;
        var dayOfWeek = set.getDay();
        for (var validDay = j = 1; j <= 42; j++) {
            var validPart1 = (j >= (dayOfWeek - (-1)));
            var validPart2 = (j <= dayOfWeek - (-monthsArray[selectedMonth]));
            if (validPart1 && validPart2) {
                this.calendarDays[j] = validDay;
                validDay++;
            } else {
                this.calendarDays[j] = '0';
            }
        }
    }
    this.makeDateString = function (trigger) {
        
        var stringFormat = new Array();
        stringFormat['y'] = set.getFullYear();
        stringFormat['m'] = (set.getMonth() + 1);
        stringFormat['d'] = (trigger) ? trigger.firstChild.nodeValue : set.getDate();
        this.setCalendarDate(stringFormat['y'], (stringFormat['m'] - 1), stringFormat['d']);
        $(this.inputField).value = stringFormat[dataFormat[0]] + dataSeparator + stringFormat[dataFormat[1]] + dataSeparator + stringFormat[dataFormat[2]];
    }
    this.setCalendarDate = function (selectedYear, selectedMonth, selectedDay) {
        
        set.setDate((selectedDay == null) ? 1 : parseInt(selectedDay));
        set.setMonth((selectedMonth == null) ? nowMonth : selectedMonth);
        set.setFullYear((selectedYear == null) ? nowYear : selectedYear);
    }
    this.getDataConfig = function (param) {
        
        switch (param) {
            case 'y':
                return set.getFullYear();
                break;
            case 'm':
                return set.getMonth();
                break;
            case 'd':
                return set.getDate();
                break;
            default:
                return set.getFullYear();
        }
    }
    this.getPrevious = function (param) {
        
        var selectedYear = set.getFullYear();
        var selectedMonth = set.getMonth() - 1;
        var selectedDay = set.getDate();
        switch (param) {
            case 'y':
                selectedYear -= 1;
                break;
            case 'm':
                selectedMonth -= 1;
                if (selectedMonth < 0) {
                    selectedMonth = 11;
                    selectedYear -= 1;
                }
                break;
            case 'd':
                var monthsArray = ((selectedYear % 4) == 0) ? monthDaysL : monthDaysY;
                selectedDay -= 1;
                if (selectedDay < 0) {
                    selectedMonth -= 1;
                    selectedDay = monthsArray[selectedMonth];
                }
                break;
        }
        this.setCalendarDate(selectedYear, selectedMonth, selectedDay);
        return true;
    }
    this.getNext = function (param) {
        
        var selectedYear = set.getFullYear();
        var selectedMonth = set.getMonth();
        var selectedDay = set.getDate();
        switch (param) {
            case 'y':
                selectedYear += 1;
                break;
            case 'm':
                selectedMonth += 1;
                if (selectedMonth > 11) {
                    selectedMonth = 0;
                    selectedYear += 1;
                }
                break;
            case 'd':
                var monthsArray = ((selectedYear % 4) == 0) ? monthDaysL : monthDaysY;
                selectedDay += 1;
                if (selectedDay > monthsArray[selectedMonth]) {
                    selectedMonth = 1;
                }
                break;
        }
        this.setCalendarDate(selectedYear, selectedMonth, selectedDay);
        return true;
    }


    this.createDOMElement = function (elementType, elementText, elementAttributes) {
        
        var newElement = document.createElement(elementType);
        if (elementText) {
            newElement.appendChild(document.createTextNode(elementText));
        }
        if (elementAttributes && elementAttributes.length > 0) {
            for (var j = 0; j < elementAttributes.length; j = j + 2) {
                newElement.setAttribute(elementAttributes[j], elementAttributes[j + 1]);
                if (elementAttributes[j] == 'style') { 
                    newElement.style.cssText = elementAttributes[j + 1];
                }
            }
        }
        return newElement;
    }
    this.removeChildrenFromNode = function (domNode) {
        
        if (domNode == undefined && domNode == null) {
            return;
        }
        while (domNode.hasChildNodes()) {
            domNode.removeChild(domNode.firstChild);
        }
    }
    this.showCalendar = function (inputField) {
        
        this.cancelBubbling(inputField);
        this.inputField = (!inputField.id) ? inputField : inputField.id;
        $(this.inputField).value = '';
        if (!$(this.calendarId)) {
            var htmlBody = document.getElementsByTagName('body')[0];
            var calendarDiv = this.createDOMElement('div', null, new Array('id', this.calendarId, 'class', 'calendar', 'style', 'display: none; position: absolute; left: ' + this.objLeft(inputField) + 'px; top: ' + (this.objTop(inputField) + inputField.offsetHeight) + 'px;'));
            calendarDiv.setAttribute('className', 'calendar'); // For IE
            htmlBody.appendChild(calendarDiv);
        } else {
            var calendarDiv = $(this.calendarId);
            this.removeChildrenFromNode(calendarDiv);
        }
        this.makeCalendar();
        
        var tableDOM = document.createElement("table");
        tableDOM.setAttribute('style', 'width: 100%');
        tableDOM.style.cssText = 'width: 100%'; 
        
        var tableHeader = document.createElement("thead");
        var headerText = new Array();
        headerText[0] = this.createDOMElement('a', '<', new Array('href', 'javascript: cal.getPrevious(\'m\'); cal.showCalendar(\'' + this.inputField + '\');'));
        headerText[1] = this.createDOMElement('strong', this.monthNames[cal.getDataConfig('m')] + ' ' + cal.getDataConfig('y'), null);
        headerText[2] = this.createDOMElement('a', '>', new Array('href', 'javascript: cal.getNext(\'m\'); cal.showCalendar(\'' + this.inputField + '\');'));
        var headerRow = document.createElement("tr");
        for (var j = 0; j < 3; j++) {
            headerCell = document.createElement("th");
            headerCell.appendChild(headerText[j]);
            if (j == 1) {
                headerCell.setAttribute('colSpan', '5');
            }
            headerRow.appendChild(headerCell);
        }
        tableHeader.appendChild(headerRow);
        tableDOM.appendChild(tableHeader);
        
        var tableBody = document.createElement("tbody");
        
        var daysRow = document.createElement("tr");
        
        tableBody.appendChild(daysRow);
      
        var dayNumb = this.calendarDays;
        for (var j = 1; j <= 6; j++) {
            var bodyRow = document.createElement("tr");
            for (var k = 1; k <= 7; k++) {
                var l = 7 * (j - 1) - (-k);
                if (dayNumb[l] != 0) {
                    if (dayNumb[l] == nowDay && nowMonth == cal.getDataConfig('m')) {
                        var cellAttrib = new Array('style', 'font-weight: bold');
                    } else {
                        var cellAttrib = null;
                    }
                } else {
                    dayNumb[l] = '';
                    var cellAttrib = null;
                }
                bodyRow.appendChild(this.createDOMElement('td', dayNumb[l], cellAttrib));
            }
            tableBody.appendChild(bodyRow);
        }
        tableDOM.appendChild(tableBody);
        tableDOM.setAttribute('class', 'calendar');
        calendarDiv.appendChild(tableDOM);
        calendarDiv.style.display = 'block';
        document.onclick = cal.controlCalendar;
    }

    this.cancelBubbling = function (e) {
        
        if (!e) {
            var e = window.event;
        }
        if (!e.stopPropagation) {
            e.cancelBubble = true;
        } else {
            e.stopPropagation();
        }
    }
    this.controlCalendar = function (e) {
        
        if ($(cal.calendarId)) {
            response = cal.clickedOutsideElement(cal.calendarId, e);
            if (response == true) {
                document.getElementById(cal.calendarId).style.display = 'none';
            } else {
                responseVal = (response.hasChildNodes()) ? response.firstChild.nodeValue : null;
                if (!isNaN(responseVal) && responseVal != null && responseVal.length > 0) {
                    cal.makeDateString(response);
                    document.getElementById(cal.calendarId).style.display = 'none';
                    document.getElementById(cal.inputField).focus();
                } else {
                    return true;
                }

            }
        }
    }
    this.clickedOutsideElement = function (elemId, e) {
       
        if (!e) {
            var theElement = cal.getEventTarget(window.event);
        } else {
            var theElement = cal.getEventTarget(e);
        }
        var rElement = theElement;
        while (theElement != null) {
            if (theElement.id == elemId) {
                return rElement;
            }
            theElement = theElement.offsetParent;
        }
        return theElement ? theElement : true;
    }
    this.getEventTarget = function (evt) {
        
        var eTarget = (evt.target) ? evt.target : evt.srcElement;
        if (eTarget != null) {
            if (eTarget.nodeType == 3) {
                eTarget = eTarget.parentNode;
            }
        }
        return eTarget;
    }
}
var cal = new CalendarClass;


