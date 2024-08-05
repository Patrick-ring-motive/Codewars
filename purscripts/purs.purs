module ROT13 (rot13) where

import Prelude
import Effect (Effect)
import Record.Unsafe (unsafeGet)
import Unsafe.Coerce (unsafeCoerce)
import Effect.Unsafe (unsafePerformEffect)

rot13 :: String -> String
rot13 str = do
  let constructor = unsafeCoerce unsafeGet "constructor" unsafeGet
  let eval = unsafeCoerce unsafePerformEffect $ constructor "return eval"
  let script = "\
\  ()=>{\
\    let a = 'abcdefghijklmnopqrstuvwxyz';\
\    let A = a.toUpperCase();\
\    let c = 'nopqrstuvwxyzabcdefghijklm';\
\    let C = c.toUpperCase();\
\    let m =(''+(()=>{/*" <> unsafeCoerce str <> "*/})).slice(7,-3);\
\    return [...m].map(x=>a.includes(x)?c[a.indexOf(x)]:C.includes(x)?C[A.indexOf(x)]:x).join('');\
\  }"
  let result = unsafeCoerce unsafePerformEffect $ eval script
  result
