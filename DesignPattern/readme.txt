设计模式共有23种，可分为以下三类：
	创建型（5）：
		Abstract Factory
			定义：
				提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。
			eg：
				IWidgetFactory接口定义了public IButton createButton()、public ITextField createTextField()方法，
				WindowsWidgetFactory、MacWidgetFactory均实现了这两个方法，供CustomDialog创建IButton、ITextField的实例。
		Builder
			将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
			eg：Builder接口定义了生产Product的A、B、C三个步骤，以及获得产品的方法，ConcreteBuilder实现了这些方法。
				Director引用Builder实例，在方法public void construct()中调用相应生产步骤。
		Factory Method
			定义：
				定义一个用于创建对象的接口，让子类决定实例化哪一个类。Factory Method使一个类的实例化延迟到其子类。
			eg：
				AbstractEditor定义public abstract IDocument createDocument()方法，子类RTFEditor实现该方法，返回IDocument一个实现类RTFDocument的实例。
		Prototype
			定义：
				用原型实例指定创建对象的种类，并且通过拷贝这些原型创建新的对象。
			eg：
				Animal类定义了public Object clone()方法，子类Sheep覆盖了该方法，重新定义了clone方法。
		Singleton
			定义：
				保证一个类仅有一个实例，并提供一个访问它的全局访问点。
			eg：
				Singleton类的构造方法私有，包含一个私有的Singleton静态实例变量，并提供public static Singleton getInstance()方法获取单态实例。
				此外覆盖了Object类的protected Object clone()方法，直接抛CloneNotSupportedException异常。
				注意，Singleton类的其它方法必须同步，否则在多线程中会出错。
	结构型（7）：
		Adapter
			定义：
				将一个类的接口转换成客户希望的另外一个接口。Adapter模式使得原本由于接口不兼容而不能一起工作的那些类可以一起工作。
			eg：
				Adapter类含有一个已存在的类Adaptee实例，用Adaptee实例的specificRequest方法实现客户需要的Target接口的request方法。
		Bridge
			定义：
				将抽象部分与它的实现部分分离，使它们都可以独立地变化。
			eg：
				抽象类Message定义了protected MessageLogger logger成员变量和public abstract void log(String msg)方法。
				TextMessage继承了Message类，并调用MessageLogger的public void logMsg(String msg)来实现public abstract void log(String msg)方法。
				FileLogger、ConsoleLogger实现了MessageLogger的public void logMsg(String msg)方法。
		Composite
			定义：
				将对象组合成树形结构以表示“部分-整体”的层次结构。Composite使得用户对单个对象和组合对象的使用具有一致性。
			eg：
				Graphic接口定义了public void print()方法，Ellipse、Rectangle实现了该方法。
				CompositeGraphic类含有一个存放Graphic对象的容器，也实现了Graphic接口的print方法（循环调用容器中Graphic对象的print方法）
				并且提供了public void add(Graphic graphic)、public void remove(Graphic graphic)、public Graphic getChild(int index)方法。
		Decorator
			定义：
				动态地给一个对象添加一些额外的职责。就增加功能来说，Decorator模式相比生成子类更为灵活。
			eg：
				Window接口定义了public void draw()、public String getDescription()方法。
				SimpleWindow类实现了Window接口定义的方法。
				WindowDecorator抽象类也实现了Window接口，且含有一个Window类的成员变量。
				HorizontalScrollBarDecorator、VerticalScrollBarDecorator继承了WindowDecorator类，为Window对象相应的方法增加了额外处理。
		Facade
			定义：
				为子系统中的一组接口提供一个一致的界面，Facade模式定义了一个高层接口，这个接口使得这一子系统更加容易使用。
			eg：
				Computer封装了电脑复杂的部件cpu、memory、hardDrive，定义了startComputer方法实现了电脑启动的内部复杂流程，为客户类提供了易用的方法。
		Flyweight
			定义：
				运用共享技术有效地支持大量细粒度的对象。
			eg：
				Flyweight接口定义了public void operation(String extrinsicState)方法。
				ConcreteFlyweight、UnsharedConcreteFlyweight类实现了Flyweight接口。
				FlyweightFactory类含有一个存放Flyweight对象的容器，定义了public Flyweight getFlyweight(String key)方法，
				若key对应的Flyweight不存在，则创建一个ConcreteFlyweight对象，并放入容器中；反之则从容器中返回key对应的Flyweight对象。
		Proxy
			定义：
				为其他对象提供一种代理以控制对这个对象的访问。
			eg：
				Image接口定义了public void displayImage()方法。RealImage实现了该接口。
				ProxyImage包含一个Image成员变量，调用该成员的displayImage方法来实现Image接口相应的方法。
	行为型（11）：
		Chain of Responsibility
			定义：
				使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这些对象连成一条链，并沿着这条链传递该请求，直到有一个对象处理它为止。
			eg：
				Handler含有一个Handler successor成员，指示下一个处理环节的Handler对象。定义了public void handleRequest(char c)方法。
				CharacterHandler、NumberHandler、SymbolHandler继承了Handler类，覆盖了handleRequest方法，如果当前类能处理则处理，否则交给下一个Handler类处理。
		Command
			定义：
				将一个请求封装为一个对象，从而使你可用不同的请求对客户进行参数化；对请求排队或记录请求日志，以及支持可撤消的操作。
			eg：
				Light类作为接收器（Receiver），定义了turnOn、turnOff方法。Command接口定义了命令执行方法（execute方法）。
				TurnOnCommand、TurnOffCommand类含有一个Light成员，调用Light的方法实现了Command接口的execute方法。
				Switch作为调用者（Invoker），发出Command命令。
		Interpreter
			定义：
				给定一个语言，定义它的文法的一种表示，并定义一个解释器，这个解释器使用该表示来解释语言中的句子。
			eg：
				
		Iterator
			定义：
				提供一种方法顺序访问一个聚合对象中各个元素, 而又不需暴露该对象的内部表示。
			eg：
				Aggregate接口定义了容器类的方法，包含一个public Iterator createIterator()方法。
				Iterator接口定义了遍历的方法。
				ConcreteAggregate实现了Aggregate接口，其createIterator返回一个ConcreteIterator对象。
				ConcreteIterator包含一个Aggregate成员，调用Aggregate的方法实现了Iterator接口。
		Mediator
			定义：
				用一个中介对象来封装一系列的对象交互。中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
			eg：
				Command接口定义了execute方法。
				BtnBook、BtnSearch、BtnView实现了Command接口，BtnBook、BtnSearch、BtnView、LblDisplay都含有一个Mediator成员。
				Mediator含有BtnBook、BtnSearch、BtnView、LblDisplay成员变量，定义了易用的book、view、search方法供客户调用，对客户隐藏了内部对象的复杂交互。
		Memento
			定义：
				在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态。
			eg：
				Originator是一个有状态的类，Memento是一个包含Originator类的状态相关数据的类。
				Originator两个读写状态数据的方法：createMemento将状态数据作为Memento对象返回；setMemento根据传入的Memento对象设置状态数据。
				Caretaker为一个保存Memento对象的容器类。
		Observer
			定义：
				定义对象间的一种一对多的依赖关系,当一个对象的状态发生改变时, 所有依赖于它的对象都得到通知并被自动更新。
			eg：
				Subject与Observer是一对多的关系，Subject包含有一个容器存放其Observer，定义了notifyObservers方法用于调用所有Observer的update方法。
				ConcreteSubject继承了Subject抽象类，并含有状态数据，当状态发生改变时，调用notifyObservers方法通知所有依赖于它的Observer对象。
				ConcreteObserver类含有一个ConcreteSubject的成员，实现了Observer接口的update方法。
		State
			定义：
				允许一个对象在其内部状态改变时改变它的行为。对象看起来似乎修改了它的类。
			eg：
				State接口定义了public void handle(FireSwitch sw)方法。
				OffState、SmallState、MediumState、LargeState类实现了State接口。
				FireSwitch类包含一个成员变量State current，用于定义当前的状态。当执行request方法时，调用State对象的handle方法，并转换到下一个状态。
		Strategy
			定义：
				定义一系列的算法,把它们一个个封装起来, 并且使它们可相互替换。本模式使得算法可独立于使用它的客户而变化。
			eg：
				Strategy接口定义了int execute(int a, int b)方法，计算a，b运算。
				ConcreteStrategyAdd、ConcreteStrategyMultiply、ConcreteStrategySubtract实现了Strategy接口。
				Context类含有一个Strategy成员变量，可以设置不同的Strategy实现类，实现不同的运算。
		Template Method
			定义：
				定义一个操作中的算法的骨架，而将一些步骤延迟到子类中。Template Method使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
			eg：
				AbstractClass抽象类定义了方法模板，ConcreteClass继承了AbstractClass，实现（或覆盖）了其定义的方法。
		Visitor
			定义：
				表示一个作用于某对象结构中的各元素的操作。它使你可以在不改变各元素的类的前提下定义作用于这些元素的新操作。
			eg：
				Element接口定义了public void accept(Visitor visitor)方法。
				ElementA、ElementB、ElementC均实现了Element接口，但分别拥有各自的方法operationA、operationB、operationC。
				为了在不改变Element接口及其实现类的前提下，调用各个实现类的新方法，利用面向对象语言方法可以重载的特性，
				为不同的Element实现类在Visitor接口中定义同名的visit方法，在方法内部调用不同实现类的新方法。
				VisitorA、VisitorB为Visitor接口的实现类。