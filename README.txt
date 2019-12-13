SPRING
	Inversion of control	
		1. Configure Spring Beans
			- applicationContext.xml bean id class
		2. Spring Container
			- ClassPathXMLAApplicationContext
		3. Get Beans from Container	
			-getBean(applicationContext bean id ("") , class)
	
	
	Dependency Injection
		1. Dependency interface and class
			- interface + (implements + method)
		2. Constructor in class for injection
			- constructor with dependecy
		3. Spring config dependency
			- applicationContext.xml bean id class + (bean id class + constructor-arg ref)
