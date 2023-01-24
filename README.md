[TOC]
# Overview
This component support trace log to help find logs per request, it works with MDC in slf4j
# How to use
## first and must
At the beginning, you must specify request partterns you want or not to log with trace id and trace chain by config properties below:

`tech.guanli.boot.log.trace.path-patterns`

`tech.guanli.boot.log.trace.exclude-path-patterns`

## simple use
This component is autoconfigured, that means you can use it easyly with any configuration, just add it to you project and add the patterns "%X{TRACE-ID}" as trace id to you log format expression, your logs will add trace id automaticly.

## advanced use
### trace id
- If your request with a header of trace id, the component will use it, otherwise it will be create automaticly. The default header name is **trace-id**, you can specify it by config property `tech.guanli.boot.log.trace.trace-id-header-name`
- the default key for trace id in log patterns is **TRACE-ID**, you can specify it by config property `tech.guanli.boot.log.trace.trace-id-key`
### trace chain
If you are using microservice, this component also support trace chain.

As the first service in a chain, this component will auto use **spring.application.name** as chain name, if you didn't spcify it, chain name will be **unnamed** as default. When call upstream service, bind current chain info in header.

If request header contains a chain, the chain will concat **=>_CURRENT_CHAIN_** automaticly.

The default header name of trace chain is **trace-chain**, you can specify it by config property `tech.guanli.boot.log.trace.trace-chain-header-name`

The default key for trace chain in log patterns is **TRACE-CHAIN**, you can specify it by config property `tech.guanli.boot.log.trace.trace-chain-key`

### TraceReader
Anytime you want to get current trace id or trace chain, you can use the component `tech.guanli.boot.log.trace.component.TraceReader`, it has been registered as a spring bean, you can get it easyly.
