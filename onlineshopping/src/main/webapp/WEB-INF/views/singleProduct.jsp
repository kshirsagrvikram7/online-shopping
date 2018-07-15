<div class="container">
	<div class="row">
		<div class="col-xs-12">
			<ol class="breadcrumb">
				<li><a href="${contextRoot}/home">Home</a></li>
				<li><a href="${contextRoot}/show/all/products">Products</a></li>
				<li class="active">${product.name}</li>
			</ol>
		</div>
	</div>
	<div class="row">
		<!-- Product image -->
		<div class="col-xs-12 col-sm-4" align="left">
			<div class="thumbnail">
				<img alt="" src="${images}/${product.code}.jpg" class="img img-responsive">
			</div>
		</div>
		
		<!-- Product description -->
		<div class="col-xs-12 col-sm-8" align="right">
			<h3>${product.name}</h3>
			<hr>
			
			<p>${product.description}</p>
			<hr>
			
			<h4>Price : <strong> &#8377; ${product.unitPrice} /-</strong></h4>
			<hr>
			
			<h6>Quantity Available : ${product.quantity}</h6>
			<hr>
			
			<a href="${contextRoot}/cart/add/${product.id}/product" class="btn btn-success">
				<span class="glyphicon glyphicon-shopping-cart">Add to cart</span>
			</a>
			
			<a href="${contextRoot}/show/all/products" class="btn btn-success">
				Back
			</a>
		</div>
		
	</div>
</div>