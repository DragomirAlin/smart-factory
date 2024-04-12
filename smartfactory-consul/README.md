# smartfactory-consul

```shell
- docker run -d --name sfy-consul-1 -p 8500:8500 -e CONSUL_BIND_INTERFACE=eth0 consul
- docker run -d --name sfy-consul-2 -e CONSUL_BIND_INTERFACE=eth0 -p 8501:8500 consul agent -dev -join=172.17.0.3
- docker run -d --name sfy-consul-3 -e CONSUL_BIND_INTERFACE=eth0 -p 8502:8500 consul agent -dev -join=172.17.0.3
```
