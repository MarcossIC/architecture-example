# Architectura Example
Repository that shows an example of how to make a hexagonal architecture in Java following the SOLID principles

## More Info
The hexagonal architecture is generally divided into 3 layers of abstraction (although there are some cases where it's divided into 4, but 3 is the most common). These layers are typically referred to as "Domain," "Application," and "Infrastructure."

<p user-select="none" align="center">
  <img src="https://refactorizando.com/wp-content/uploads/2020/11/Arquitectura-Hexagonal.png"/>
</p>

Generally, these layers follow a top-down dependency rule, where the upper layer knows about the lower ones, but the lower layers are unaware of the upper ones, as can be seen in the image.

Starting with the infrastructure layer, it's the highest layer in the hierarchy, thus depending on both the domain and the application since it interacts with both. In this layer, you typically place everything related to input and output connections and application configuration. For instance, input connections could include a Kafka consumer, RabbitMQ, or an API controller. Examples of output connections might involve database connections, Kafka consumers, sending emails, or REST connections (like RestTemplate, Feign, or WebClient).

Moving on to the application layer, this layer doesn't have knowledge of the infrastructure but knows about the domain. Here, you usually place the logic related to use cases and where you call all the domain logic or other application services.

The lowest layer in the hierarchy is the domain layer. Even though it's the lowest, it can be considered the most important because it contains all the domain logic or bussiness logic of your application, including models, interfaces, and any other utilities you may need.

#Ports And Adapters

Some might wonder, "But what if the logic of use cases resides in the application layer, the repositories are in the domain layer, and the outgoing database connections are in the infrastructure layer? How do they communicate? Because in theory, according to the top-down dependency rule, the application and the domain are unaware of the infrastructure.

To comprehend how this works, it's important to consider two concepts, which are another way to refer to this architecture, and this is the "Ports and Adapters" architecture.

<p user-select="none" align="center">
  <img src="https://raw.githubusercontent.com/MarcossIC/architecture-example/main/architectureExample.png"/>
</p>
