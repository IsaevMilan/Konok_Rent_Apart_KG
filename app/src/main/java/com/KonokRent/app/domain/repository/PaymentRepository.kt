package com.airbnbclone.app.domain.repository

data class PaymentMethod(
    val id: String,
    val type: PaymentType,
    val title: String,
    val subtitle: String,
    val isDefault: Boolean
)

enum class PaymentType {
    CARD,
    PAYPAL
}

interface PaymentRepository {
    suspend fun getPaymentMethods(userId: String): List<PaymentMethod>
    suspend fun addPaymentMethod(
        userId: String,
        type: PaymentType,
        cardNumber: String? = null,
        cardholderName: String? = null,
        expiryDate: String? = null,
        cvv: String? = null
    ): PaymentMethod
    
    suspend fun deletePaymentMethod(paymentMethodId: String)
    suspend fun setDefaultPaymentMethod(paymentMethodId: String)
}

