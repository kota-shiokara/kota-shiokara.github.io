import { instantiate } from './kota-shiokara.github.io.uninstantiated.mjs';

await wasmSetup;

instantiate({ skia: Module['asm'] });