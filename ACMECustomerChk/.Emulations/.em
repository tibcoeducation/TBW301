<?xml version="1.0" encoding="ASCII"?>
<emulation:EmulationData xmlns:emulation="http:///emulation.ecore" isBW="true" location="ACMECustomerChk">
  <ProcessNode Id="acmecustomerchk.CheckCustCredit" Name="acmecustomerchk.CheckCustCredit" ModelType="BW" moduleName="ACMECustomerChk">
    <Operation Name="callProcess" serviceName="acmecustomerchk.CheckCustCredit">
      <Inputs Id="583d4595-bc24-4e4c-ac99-c611e8bde708ACMECustomerChk_acmecustomerchk.CheckCustCredit_callProcess_Start" Name="Start" isDefault="true" type="CALLPROCESS"/>
    </Operation>
  </ProcessNode>
  <ProcessNode Id="acmecustomerchk.CheckCustCreditService" Name="acmecustomerchk.CheckCustCreditService" ModelType="BW" moduleName="ACMECustomerChk">
    <Operation Name="CheckOp" serviceName="CheckCustCredit">
      <Inputs Id="ACMECustomerChk_acmecustomerchk.CheckCustCreditService_CheckOp_Request" Name="Request" isDefault="true">
        <informations Name="parameters" tnsName="tns:" nameSpaceValue="http://www.tibco.com/CheckCustCredit/" nameSpace="xmlns:tns" partType="Element">
          <nameSpaces prefix="tns" nameSapce="http://www.tibco.com/CheckCustCredit/"/>
          <nameSpaces prefix="tns0" nameSapce="/Processes/CheckCustCredit.xsd"/>
          <nameSpaces prefix="xs" nameSapce="http://www.w3.org/2001/XMLSchema"/>
          <Parameter Name="tns0:InSchema">
            <parameters Name="CustID" Value="1234" type="string"/>
            <parameters Name="CreditAmt" Value="1212" type="double"/>
          </Parameter>
        </informations>
        <SoapMessage>type</SoapMessage>
      </Inputs>
    </Operation>
  </ProcessNode>
</emulation:EmulationData>
