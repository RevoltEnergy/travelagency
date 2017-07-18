<c:if test="${!empty listCustomers}">
    <spring:url value="/resources/js/popupCenter.js" var="popupCenter" />
    <script src="${popupCenter}"></script>
    <table class="tg">
        <tr>
            <th width="10">ID</th>
            <th width="40">Name</th>
            <th width="70">Surname</th>
            <th width="20">Edit</th>
            <th width="30">Delete</th>
        </tr>
        <c:forEach items="${listCustomers}" var="customer">
            <tr>
                <td>${customer.id}</td>
                <td><a href="/customerdata/${customer.id}"
                       onclick="PopupCenter('/customerdata/${customer.id}', 'Customer Details', 700, 400);
                    return false;">${customer.firstname}</a></td>
                <td>${customer.lastname}</td>
                <td><button type="button" class="button" name="edit"
                            onclick="location.href='<c:url value='/edit/${customer.id}'/>'">Edit</button></td>
                <td><button type="button" class="button" name="delete"
                            onclick="location.href='<c:url value='/remove/${customer.id}'/>'">Delete</button></td>
            </tr>
        </c:forEach>
    </table>
</c:if>