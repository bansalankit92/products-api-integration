package com.extensions.domains.sales.model;

import com.google.gson.annotations.SerializedName;
import com.extensions.domains.sales.Contract;

public class SFContract {

    @SerializedName("Id")
    public String id;
    @SerializedName("AccountId")
    public String accountId;
    @SerializedName("Pricebook2Id")
    public String pricebook2Id;
    @SerializedName("OwnerExpirationNotice")
    public String ownerExpirationNotice;
    @SerializedName("StartDate")
    public String startDate;
    @SerializedName("EndDate")
    public String endDate;
    @SerializedName("ContractTerm")
    public int contractTerm;
    @SerializedName("OwnerId")
    public String ownerId;
    @SerializedName("Status")
    public String status;
    @SerializedName("CompanySignedId")
    public String companySignedId;
    @SerializedName("CompanySignedDate")
    public String companySignedDate;
    @SerializedName("CustomerSignedId")
    public String customerSignedId;
    @SerializedName("CustomerSignedTitle")
    public String customerSignedTitle;
    @SerializedName("CustomerSignedDate")
    public String customerSignedDate;
    @SerializedName("ActivatedById")
    public String activatedById;
    @SerializedName("ActivatedDate")
    public String activatedDate;
    @SerializedName("StatusCode")
    public String statusCode;
    @SerializedName("Description")
    public String description;
    @SerializedName("IsDeleted")
    public Boolean isDeleted;
    @SerializedName("ContractNumber")
    public String contractNumber;
    @SerializedName("CreatedDate")
    public String createdDate;
    @SerializedName("CreatedById")
    public String createdById;
    @SerializedName("LastModifiedDate")
    public String lastModifiedDate;
    @SerializedName("LastModifiedById")
    public String lastModifiedById;


    public static Contract to(SFContract sfEvent) {
        Contract event = new Contract();
//               event.id = sfEvent.id;
//               event.ownerId = sfEvent.ownerId;
//               event.location = sfEvent.location;
//               event.isGroupEvent = sfEvent.isGroupEvent;
//               event.isPrivate = sfEvent.isPrivate;
//               event.leadId = sfEvent.leadId;
//               event.subject = sfEvent.subject;
//               event.accountId = sfEvent.accountId;
//               if (sfEvent.lastModifiedDate != null)
//                   event.lastModifiedDate = new Date(sfEvent.lastModifiedDate);
//               if (sfEvent.createdDate != null)
//                   event.createdDate = new Date(sfEvent.createdDate);
//               if (sfEvent.startDateTime != null)
//                   event.startDateTime = new Date(sfEvent.startDateTime);
//               if (sfEvent.endDateTime != null)
//                   event.endDateTime = new Date(sfEvent.endDateTime);
               return event;
    }

    public static SFContract from(Contract sfEvent) {
        SFContract event = new SFContract();
//                   event.id = sfEvent.id;
//                   event.ownerId = sfEvent.ownerId;
//                   event.location = sfEvent.location;
//                   event.isGroupEvent = sfEvent.isGroupEvent;
//                   event.isPrivate = sfEvent.isPrivate;
//                   event.leadId = sfEvent.leadId;
//                   event.subject = sfEvent.subject;
//                   event.accountId = sfEvent.accountId;
//                   if (sfEvent.lastModifiedDate != null)
//                       event.lastModifiedDate = new Date(sfEvent.lastModifiedDate);
//                   if (sfEvent.createdDate != null)
//                       event.createdDate = new Date(sfEvent.createdDate);
//                   if (sfEvent.startDateTime != null)
//                       event.startDateTime = new Date(sfEvent.startDateTime);
//                   if (sfEvent.endDateTime != null)
//                       event.endDateTime = new Date(sfEvent.endDateTime);
                   return event;
        }
}