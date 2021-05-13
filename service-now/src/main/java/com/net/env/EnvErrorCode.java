package com.net.env;

public enum EnvErrorCode
{
    AkkaBackPressure,
    AkkaNetworkError,
    AkkaTimeout,
    AkkaInternal,

    ServerAuthFailed,
    ServerLockFailed,
    ServerValidationFailed,
    ServerInternal,

    DbBackPressure,
    DbDocumentDoesNotExist,
    DbDocumentAlreadyExists,
    DbCasMismatch,
    DbTemporaryFailure,
    DbInternal,

    ExtnNetworkError,
    ExtnTimeout,
    ExtnInternal,

    InvalidConversation,
    NotAuthorized,

    ScriptNetworkError,
    ScriptTimeout,
    ScriptInternal;

    public boolean isBackPressure() {
        return this == AkkaBackPressure || this == DbBackPressure || this == AkkaTimeout;
    }

    public boolean isServerDown() {
        return this == AkkaNetworkError;
    }
}