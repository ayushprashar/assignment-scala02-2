package edu

abstract class Payment
case class PayTM(amount: Float) extends Payment
case class FreeCharge(amount: Float) extends Payment
case class NetBanking(amount: Float) extends Payment
case class CardPayment(amount: Float) extends Payment
case class Cash(amount: Float) extends Payment


