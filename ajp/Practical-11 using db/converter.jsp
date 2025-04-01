<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% String fromError = (String) request.getAttribute("error_from_currency"); %>
<% String toError = (String) request.getAttribute("error_to_currency"); %>
<% String amountError = (String) request.getAttribute("error_amount"); %>

<!DOCTYPE html>
<html>
    <head>
        <title>Currency Converter</title>
        <script src="https://unpkg.com/@tailwindcss/browser@4"></script>
    </head>
    <body>
        <h2 class="text-center text-3xl font-semibold my-3">Currency Converter</h2>
        <form action="Convert" method="post" class="max-w-3xl mx-auto border border-slate-500 rounded-lg p-5">
            <div class="flex flex-col gap-1">
                <label>From Currency:</label>
                <select  id="fromCurrency" name="fromCurrency" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
                    <option selected value="">Choose From currency</option>
                    <%
                        List<String> currencies = (List<String>) request.getAttribute("currencies");
                        if (currencies != null) {
                            for (String currency : currencies) {
                    %>
                    <option value="<%= currency%>"><%= currency%></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>
            <% if (fromError != null) {%>
            <p class="text-red-400"><%= fromError%></p>
            <% } %>

            <div class="flex flex-col gap-1 mt-3">
                <label>To Currency:</label>
                <select name="toCurrency" class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5">
                    <option selected value="">Choose To currency</option>
                    <%
                        if (currencies != null) {
                            for (String currency : currencies) {
                    %>
                    <option value="<%= currency%>"><%= currency%></option>
                    <%
                            }
                        }
                    %>
                </select>
            </div>
            <% if (toError != null) {%>
            <p class="text-red-400"><%= toError%></p>
            <% }%>
            <div class="flex flex-col gap-1 mt-3">
                <label>Amount:</label>
                <input placeholder="Enter amount" type="number" name="amount" step="0.01"  class="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-2.5" />
            </div>
            <% if (amountError != null) {%>
            <p class="text-red-400"><%= amountError%></p>
            <% }%>
            <button type="submit" class="mt-4 text-white bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:ring-blue-300 font-medium rounded-lg text-sm px-5 py-2.5 me-2 mb-2 dark:bg-blue-600 dark:hover:bg-blue-700 focus:outline-none dark:focus:ring-blue-800" >Convert</button>
        </form>
    </body>
</html>
