<h1>Add a Customer<span>Please fill all the texts in the fields.</span></h1>
<p>
    <c:if test="${!empty customer.firstname}">
        <label>
            <span>
                <form:label path="id">
                    <spring:message text="ID :"/>
                </form:label>
            </span>

                <form:input path="id" readonly="true" size="8" disabled="true"/>
                <form:hidden path="id"/>

        </label>
    </c:if>
    <label>
        <span>
            <form:label path="firstname">
                <spring:message text="Name :"/>
            </form:label>
        </span>
        <form:input path="firstname" placeholder="Type a name"/>
    </label>
    <label>
        <span>
            <form:label path="lastname">
                <spring:message text="Surname :"/>
            </form:label>
        </span>
        <form:input path="lastname" placeholder="Type a surname"/>
    </label>
    <c:if test="${!empty customer.firstname}">
        <label>
            <span>
                <div>
                     <button id="begin_button" type="button" class="button" name="back"
                             onclick="location.href='<c:url value="/customers"/>'">Manage orders</button>
                </div>
            </span>
        </label>
    </c:if>
    <label>
        <br>
        <span>&nbsp;</span>
        <c:if test="${!empty customer.firstname}">
            <div>
                <button type="submit" class="button">Edit Customer</button>
                <button type="button" class="button" name="back" onclick="history.back()">Cancel</button>
            </div>
        </c:if>
        <c:if test="${empty customer.firstname}">
            <div>
                <button type="submit" class="button">Add Customer</button>
            </div>
        </c:if>
    </label>
</p>