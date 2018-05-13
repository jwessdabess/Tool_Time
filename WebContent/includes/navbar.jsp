<div class="navbar"> 
			<div class="dropdown">
		    	<button class="dropbtn">Company Profile </button>
		    	<div class="dropdown-content"> 
					<a href="/Tool_Time/aboutUs.jsp">About Us</a> 
					<a href="#">Contact Us</a> 
				</div>
		  	</div>
			<div class="dropdown">
		    	<button class="dropbtn">Departments </button>
		    	<div class="dropdown-content"> 
					<a href="shopDepartment?department=Electrical">Electrical</a>
					<a href="shopDepartment?department=Hardware">Hardware</a> 
					<a href="shopDepartment?department=Paint">Paint</a>
					<a href="shopDepartment?department=Plumbing">Plumbing</a>
					<a href="shopDepartment?department=Tools">Tools</a>
				</div>
			</div>
			<div class="dropdown">
		    	<button class="dropbtn">Account </button>
		    	<div class="dropdown-content"> 
					<a href="/Tool_Time/login.jsp">Login</a>
					<a href="/Tool_Time/register.jsp">Registration</a> 
					<a href="ProfileServlet">Profile</a> 
		  		</div>
			</div>
			<div class="dropdown">
		  		<button class="dropbtn">Contact Us  </button>
		  		<div class="dropdown-content"> 
					<a href="#">Store Location</a> 
					<a href="#">FAQ</a> 
					<a href="#">Claim Center</a> 
				</div>
			</div>
			<div style="float: right;text-align:right">
			  <a href="CartServlet?viewCart=true"><i class="material-icons" style="font-size:48px;color:peru">shopping_cart</i> </a>
			<b><c:if test="${empty numItems}">
			   0 item(s)
			</c:if>
			<c:if test="${not empty numItems}">
			${numItems} item(s)
			</c:if>
			</b>
			</div>
		</div>