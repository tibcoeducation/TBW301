<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="ACMEShippingV2">
  <ProcessNode Id="acmeshippingv2.ACMEShipping" Name="acmeshippingv2.ACMEShipping" ModelType="BW" moduleName="ACMEShippingV2">
    <Operation Name="DoShippingOp" serviceName="ShippingInput">
      <Inputs Id="cc80f388-1a11-4ed3-87ae-9c208dade16fACMEShippingV2_acmeshippingv2.ACMEShipping_DoShippingOp_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tibco.com/bwp/services/shippingabstrct" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tibco.com/bwp/services/shippingabstrct"/>
          <nameSpaces prefix="AC" nameSapce="http://www.tibco.com/bwp/schemas/acmeshipping"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="AC:ShippingRequest">
            <parameters Name="AC:CustID" Value="8889" type="string" nameSpace="http://www.w3.org/2001/XMLSchema"/>
            <parameters Name="AC:OrderAmount" Value="1212" type="double" nameSpace="http://www.w3.org/2001/XMLSchema"/>
            <parameters Name="AC:Priority" Value="LOW" type="string" nameSpace="http://www.w3.org/2001/XMLSchema"/>
            <parameters Name="AC:OrderDate" Value="2023-01-16" type="date" nameSpace="http://www.w3.org/2001/XMLSchema"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
