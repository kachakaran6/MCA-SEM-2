<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Conversion Result</title>
    <!-- Tailwind CSS CDN link -->
    <script src="https://cdn.tailwindcss.com"></script>
  </head>
  <body
    class="bg-gray-100 text-gray-900 font-sans flex items-center justify-center min-h-screen"
  >
    <div class="bg-white p-8 rounded-lg shadow-lg max-w-md w-full">
      <h2 class="text-2xl font-bold text-center text-blue-600 mb-6">
        Conversion Result
      </h2>
      <div class="mb-4">
        <p class="text-lg font-semibold text-gray-800">From:</p>
        <p class="text-gray-700">${fromCurrency}</p>
      </div>
      <div class="mb-4">
        <p class="text-lg font-semibold text-gray-800">To:</p>
        <p class="text-gray-700">${toCurrency}</p>
      </div>
      <div class="mb-4">
        <p class="text-lg font-semibold text-gray-800">Amount:</p>
        <p class="text-gray-700">${amount}</p>
      </div>
      <div class="mb-6">
        <p class="text-lg font-semibold text-gray-800">Converted Amount:</p>
        <p class="text-gray-700">${convertedAmount}</p>
      </div>
      <div class="text-center">
        <a href="Convert" class="text-blue-600 hover:underline font-medium"
          >Convert Again</a
        >
      </div>
    </div>
  </body>
</html>
