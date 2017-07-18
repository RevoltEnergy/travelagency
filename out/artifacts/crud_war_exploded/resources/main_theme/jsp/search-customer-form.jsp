<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<p>
    <label>
        <span>
            <form:label path="searchCustomer" cssClass="field-style field-split align-left">
                <spring:message text="Search Customer :"/>
            </form:label>
        </span>
        <form:input path="searchCustomer" cssClass="field-style field-split" maxlength="50" cssStyle="width:30%" placeholder="Type a surname"/>
        <input type="submit" value="<spring:message text="Search"/>" class="button"/>
        <button type="button" class="button" name="back" onclick="location.href='../../customers'">Cancel</button>
    </label>
</p>