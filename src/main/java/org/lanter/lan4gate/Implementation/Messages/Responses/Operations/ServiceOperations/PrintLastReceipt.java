package org.lanter.lan4gate.Implementation.Messages.Responses.Operations.ServiceOperations;

import org.lanter.lan4gate.Messages.Fields.ResponseFieldsList;
import org.lanter.lan4gate.Messages.OperationsList;
import org.lanter.lan4gate.Implementation.Messages.Responses.Response;
import org.lanter.lan4gate.Implementation.Messages.Responses.ResponseBuilder;

public class PrintLastReceipt extends Response {
   public PrintLastReceipt(OperationsList operationCode) {
       setOperationCode(OperationsList.PrintLastReceipt);
       addOptionalFields(ResponseFieldsList.EcrMerchantNumber);
       addOptionalFields(ResponseFieldsList.OriginalOperationCode);
       addOptionalFields(ResponseFieldsList.OriginalOperationStatus);

       //Так как неизвестна операция, то необходимо забрать поля из используемой
       if(!operationCode.equals(OperationsList.PrintLastReceipt)) {
           ResponseBuilder builder = new ResponseBuilder();
           Response operation = builder.prepareResponse(operationCode);
           if(operation != null) {
               addMandatoryFieldsGroup(operation.getMandatoryFields());
               addOptionalFieldsGroup(operation.getOptionalFields());
           }
       }
   }
}
