package edu.cmu.dynet

object Device {
  def apply(str:String): internal.Device = {
    if(str == "" || str == "default") internal.dynet_swig.getDefault_device
    else internal.dynet_swig.get_device_manager().get_global_device(str)
  }

  def default(): internal.Device = internal.dynet_swig.getDefault_device

  def available(): Vector[internal.Device] = {
    val dm = internal.dynet_swig.get_device_manager()
    val tmp = for(l <- 0L until dm.num_devices()) yield dm.get(l)
    tmp.toVector
  }

  def num(): Long = internal.dynet_swig.get_device_manager().num_devices()
}
