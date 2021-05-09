<%= session.getId() %>
<form action="/example-1.0.0/login" method="post">
	<label for="email">email: </label><input id="email" type="text" name="email"/><br/>
	<label for="password">password: </label><input id="password" type="password" name="password"/><br/>
	<label for="callback_url">callback_url: </label><input id="callback_url" type="text" name="callback_url" value="/"/><br/>
	<input type="submit" value="login"/><br/>
</form>
