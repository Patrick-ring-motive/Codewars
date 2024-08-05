module LeapYears (isLeapYear) where

import Prelude
import Effect (Effect)
import Record.Unsafe (unsafeGet)
import Unsafe.Coerce (unsafeCoerce)
import Effect.Unsafe (unsafePerformEffect)

funct :: Int -> Int
funct x = x

getFunctionConstructor :: forall r. Record r -> Effect (forall a b. a -> b)
getFunctionConstructor obj = unsafeCoerce $ unsafeGet "constructor" obj

isLeapYear :: Int -> Boolean
isLeapYear year = do
  let cnstr = getFunctionConstructor {constructor: unsafeCoerce funct}
  let constructor = unsafeCoerce unsafeGet "constructor" cnstr
  let eval = unsafeCoerce unsafePerformEffect $ constructor "return eval"
  let script = "()=>!!((!(" <> unsafeCoerce year <>"%4))&&((" <> unsafeCoerce year <>"%100)||(!(" <> unsafeCoerce year <>"%400))))"
  let result = unsafeCoerce unsafePerformEffect $ eval script
  if result
  then true
  else false
