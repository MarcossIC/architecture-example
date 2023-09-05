# Clean Architectura Example
Repository that shows an example of how to make a clean architecture in Java following the SOLID principles

## More Info
The hexagonal architecture is generally divided into 3 layers of abstraction (although there are some cases where it's divided into 4, but 3 is the most common). These layers are typically referred to as "Domain," "Application," and "Infrastructure."

<p user-select="none" align="center">
  <img src="https://refactorizando.com/wp-content/uploads/2020/11/Arquitectura-Hexagonal.png"/>
</p>

Generally, these layers follow a top-down dependency rule, where the upper layer knows about the lower ones, but the lower layers are unaware of the upper ones, as can be seen in the image.

Starting with the infrastructure layer, it's the highest layer in the hierarchy, thus depending on both the domain and the application since it interacts with both. In this layer, you typically place everything related to input and output connections and application configuration. For instance, input connections could include a Kafka consumer, RabbitMQ, or an API controller. Examples of output connections might involve database connections, Kafka consumers, sending emails, or REST connections (like RestTemplate, Feign, or WebClient).

Moving on to the application layer, this layer doesn't have knowledge of the infrastructure but knows about the domain. Here, you usually place the logic related to use cases and where you call all the domain logic or other application services.

The lowest layer in the hierarchy is the domain layer. Even though it's the lowest, it can be considered the most important because it contains all the domain logic or bussiness logic of your application, including models, interfaces, and any other utilities you may need.

# Ports And Adapters

Some might wonder, "But what if the logic of use cases resides in the application layer, the repositories are in the domain layer, and the outgoing database connections are in the infrastructure layer? How do they communicate? Because in theory, according to the top-down dependency rule, the application and the domain are unaware of the infrastructure.

To comprehend how this works, it's important to consider two concepts, which are another way to refer to this architecture, and this is the "Ports and Adapters" architecture.

<p user-select="none" align="center">
  <img src="https://raw.githubusercontent.com/MarcossIC/architecture-example/main/architectureExample.png"/>
</p>

As depicted in the image, communication can be achieved through "Ports" and "Adapters." To better grasp this concept, when we refer to a "port," we are essentially talking about interfaces. "Adapters," on the other hand, are nothing more than the adaptation of a port, in other words, an implementation of the interface. This flexibility exists because when we define a port in the domain layer, its implementation can reside in either the infrastructure or the application layer. This flexibility stems from the fact that the port remains agnostic to how or where  is implemented.

Also, since the application and infrastructure layers are aware of the domain layer, they can consume these ports. Therefore, we continue to comply with the dependency rule, as the domain layer remains independent of the other layers while also serving as a bridge to communicate between the application and infrastructure layers.

# Vertical Slizing 
"Vertical slicing" is a technique that can be applied to virtually any software architecture and proves to be highly beneficial. But why is it applied and how does it work? The reason for employing this technique is quite straightforward. As a development project progresses and the number of files increases, there comes a point where navigating through all these files can become challenging and confusing when trying to find the one you need. This is where "vertical slicing" comes into play.

**Horizontal Structure**
<p user-select="none" align="center">
  <img src="https://xurxodev.com/content/images/2017/02/Horizontal_Slice.png"/>
</p>

**Vertical Structure**. One way to do it might look like this
<p user-select="none" align="center">
  <img src="https://xurxodev.com/content/images/2017/03/Vertical-Slice.png"/>
</p>

The concept of "vertical slicing" is based on dividing the project's structure into multiple "slices." Each "slice" has the function of grouping a set of functionalities that are related by the same concept or feature. For example, in the hexagonal architecture, it can be implemented by creating three layers, which are the domain, the application, and the infrastructure. Each of these layers groups a set of functionalities. However, if we stop at this point, we still face the same problem because this separation alone is not sufficient. To address this issue more effectively, one of the best ways to apply "vertical slicing" is through the "contexts" or "entities" of your domain. This allows you, when entering and exploring the structure, to clearly identify the folder you need at a glance. This is because when adding extra functionality, the first thing you will encounter are the contexts, and you can be sure that what is within this group of functions is related only to this context. This way, you won't get confused or have unrelated classes mixed in that you may not need or want to see for this specific case.

# Ports And Adapter Architecture + vertical slizing
Once these concepts are understood, combining "vertical slicing" with "clean architecture" produces quite a favorable result. And this is the way I decided to apply it in this project:

<p user-select="none" align="center">
  <img src="./imgs/vertizal_slizing_clean_architecture.jpg"/>
</p>

# Shared Context
When we mention the concept of dividing by context, an additional feature that further enhances the effectiveness of combining "vertical slicing" and "clean architecture" is that different contexts should not have mutual awareness; in other words, they should function as independent modules. This practice significantly contributes to code quality. However, there may be instances where a class is needed in multiple contexts for specific reasons. To address this situation, it is recommended to incorporate the "Shared" module, where both domain and infrastructure folders would be included. This makes sense because there might be shared elements in these areas, even though having shared use cases would not be logical. The "Shared" context proves useful in these particular cases.

# CQRS (Command Query Responsability Segregation)
CQRS, which stands for Command Query Responsibility Segregation, is an architectural pattern that focuses on separating read and write operations within a data store. Implementing CQRS in an application can have a positive impact on performance, scalability, and security. This is because in a conventional system, all operations interact with the same database, which can lead to overload when the requirements are high. By applying the CQRS pattern, these two aspects are separated, alleviating the load and preventing issues in one area from affecting the other. This, in turn, contributes to the resilience of the system, preventing the breakdown of one part from affecting the entire codebase.

In this example, I have also applied the CQRS pattern by separating write and read operations. To achieve this, I've created a 'mirror' of the user context, allowing for a contrast between the CQRS approach and the more conventional one.

To implement the CQRS pattern in this case, I've used the 'bus' and 'handler' patterns. These patterns simplify implementation and contribute to cleaner and decoupled code.

### Handler
A 'Handler' is a pattern used to manage events and execute the necessary logic to perform specific actions. In this context, they are used to handle both queries and commands, resulting in two types of handlers: 'Command Handler' and 'Query Handler.'

### Bus
On the other hand, the 'Bus' pattern is a widely used architectural approach as an intermediary for communicating and coordinating components or modules within an application. This pattern facilitates communication between different components without the need for tight coupling. It is also known as a 'Message Bus' or 'Event Bus.'

Therefore, with these two components, I can manage the received commands and queries. The handlers remain decoupled from the caller. Furthermore, by using the bus, I can ensure that the controller in the infrastructure layer directs the command or query to the corresponding handler in the application layer. This allows each component to remain decoupled and facilitates system modularity.

<p user-select="none" align="center">
  <img src="./imgs/cqrs_pattern.jpg"/>
</p>

### Consideraciones
However, implementing the CQRS pattern involves introducing what is known as 'accidental complexity.' But what does this term mean? Accidental complexity refers to the phenomenon that occurs when additional components are added to an architecture, causing that architecture to become more intricate. This can have implications, such as spending additional time incorporating new functionalities according to specific requirements. Furthermore, when integrating a new team member, they may require more time to become familiar with and adapt to working in that specific part of the architecture.
